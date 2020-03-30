package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.BookBorrowLogMapper;
import com.lib.management.mapper.BookInfoMapper;
import com.lib.management.mapper.BooksMapper;
import com.lib.management.mapper.UserMapper;
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
        boolean flag = false;
        try {
            bookBorrowLogMapper.insert(log);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
