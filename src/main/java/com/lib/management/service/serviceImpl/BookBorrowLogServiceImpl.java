package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.*;
import com.lib.management.model.BookBorrowLog;
import com.lib.management.model.BookInfo;
import com.lib.management.model.Books;
import com.lib.management.model.User;
import com.lib.management.service.BookBorrowLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * @author:guan
 * @2020/3/25 16:54
 * 文件信息：
 */
@Service
public class BookBorrowLogServiceImpl implements BookBorrowLogService {
    @Resource
    private BookBorrowLogMapper bookBorrowLogMapper;

    @Resource
    private AdminConstDataMapper adminConstDataMapper;

    //查询借书记录
    @Override
    public BookBorrowLog queryBookLog(Integer bookLogId) {
        BookBorrowLog bookBorrowLog = bookBorrowLogMapper.selectByPrimaryKey(bookLogId);
        return bookBorrowLog;
    }

    @Override
    public Integer updateBookLog(BookBorrowLog bookBorrowLog) {
        int i = bookBorrowLogMapper.updateByPrimaryKey(bookBorrowLog);
        return i;
    }

    @Override
    public boolean borrowLog(Books book) {
        BookBorrowLog log = book.toLog();
        //检查数据库错误
        int errorPossible = 0;
        //如果日志中日志中一本书已经有活跃状态，则设置错误值
        if(bookBorrowLogMapper.selectLogIdForCheckDataBaseError(book.getBookId()) != null){
            errorPossible = bookBorrowLogMapper.selectLogIdForCheckDataBaseError(book.getBookId());
        }
        //若不是默认错误值，则无法借阅
        if(errorPossible > 0 ){
            return false;
        }
        boolean flag = false;
        try {
            bookBorrowLogMapper.insert(log);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }



    @Override
    public boolean returnBookLog(int bookId) {
        BookBorrowLog log = bookBorrowLogMapper.selectByBookId(bookId);
        //从数据库获取数据常量，获取保证金数额
        if(log == null){
            return  false;
        }
        float permitNumber = adminConstDataMapper.selectByPrimaryKey("permit_number")
                .getConstValue()
                .floatValue();
        log.setPermitMoneyNumber(BigDecimal.valueOf(permitNumber));
        Date now = new Date();
        //设置保证金状态
        log.setPermitMoneyStatus(1);
        //超期处理
        if(log.getBookReturnTime().before(now)){
            long day=(now.getTime()-log.getBookReturnTime().getTime())/(24*60*60*1000);
            //获取罚金常量
            float fineNumber = adminConstDataMapper.selectByPrimaryKey("fine_number")
                    .getConstValue()
                    .floatValue();
            log.setFineNumber(BigDecimal.valueOf(day * fineNumber));
            log.setBookBorrowStatus(3);
            log.setFineStatus(1);
        }else{
            //非超期则返回非超期操作/设置日志为已归还状态
            log.setBookBorrowStatus(1);
            //设置罚金为无
            log.setFineNumber(BigDecimal.valueOf(0));
            log.setFineStatus(0);
        }
        boolean flag = false;
        try{
            bookBorrowLogMapper.updateByPrimaryKeySelective(log);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
