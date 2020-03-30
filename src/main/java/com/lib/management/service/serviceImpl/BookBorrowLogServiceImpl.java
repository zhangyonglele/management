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
    //借阅图书实现
    @Resource
    private BookInfoMapper bookInfoMapper;
    @Resource
    private BookBorrowLogMapper bookBorrowLogMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private BooksMapper booksMapper;
    @Override
    public String borrowBooks(Integer userId,Integer bookId) {
        Books books = booksMapper.selectByPrimaryKey(bookId);
        BookInfo bookInfo = bookInfoMapper.selectByPrimaryKey(books.getBookInfoId());
        Date borrowTime = new Date();
        //        //创建Calendar 的实例
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(borrowTime);
        //截至还书时间一个月之后
        calendar.add(Calendar.MONTH, 1);
        Date oneMonthLater = calendar.getTime();
        Integer bookBorrowStatus = books.getBookBorrowStatus();
        if (bookBorrowStatus==0){
            //设置books表
            books.setBookBorrowUpdateTime(borrowTime);
            books.setBookBorrowBy(userId);
            books.setBookBorrowedTime(borrowTime);
            books.setBookShouldReturnBefore(oneMonthLater);
            books.setBookActiveStatus(0);
            //设置bookinfo表
            Integer booknum = bookInfo.getBookCopyNumber();
            //检查图书副本，更新图书状态
            if (booknum>0){
                if (--booknum>0)
                    bookInfo.setBookStatus(0);
            }
            bookInfo.setBookCopyNumber(booknum);
            //更新图书借阅日志表
            User user = userMapper.selectByPrimaryKey(userId);
            //创建booklog
            BookBorrowLog bookBorrowLog = new BookBorrowLog();
            bookBorrowLog.setBookBorrowBy(user.getUserId());
            bookBorrowLog.setBookId(bookId);
            bookBorrowLog.setBookBorrowTime(borrowTime);

//        bookBorrowLog.setBookReturnTime(oneMonthLater);
            bookBorrowLog.setBookBorrowStatus(0);
            bookBorrowLog.setPermitMoneyStatus(user.getPermitStatus());
            bookBorrowLog.setPermitMoneyNumber(new BigDecimal(50));
            bookBorrowLog.setFineStatus(0);
            bookBorrowLog.setFineNumber(new BigDecimal(0));
            //保存信息
            booksMapper.updateByPrimaryKey(books);
            bookInfoMapper.updateByPrimaryKey(bookInfo);
            bookBorrowLogMapper.insert(bookBorrowLog);
            return "success";
        }
        else if (bookBorrowStatus==1)
            return "borrowed";
        else if (bookBorrowStatus==3)
            return "preparing";
        else if (bookBorrowStatus==4)
            return "ordered";
        return null;
    }
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
}
