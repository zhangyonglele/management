package com.lib.management.controller;

import com.lib.management.model.BookBorrowLog;
import com.lib.management.model.BookInfo;
import com.lib.management.model.Books;
import com.lib.management.service.BookBorrowLogService;
import com.lib.management.service.BookInfoService;
import com.lib.management.service.BookService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author:guan
 * @2020/3/25 17:24
 * 文件信息：
 */
@RestController
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ManagementApplication.class)
public class BookBorrowLogController {
    @Resource
    private BookBorrowLogService bookBorrowLogService;
    @Resource
    private BookInfoService bookInfoService;
    @Resource
    private BookService bookService;
    @RequestMapping("/{userid}/book/borrow/{bookid}")
//    借阅图书
    public UniversalResponseBody bookBorrow(@PathVariable("userid") Integer userId,
                                            @PathVariable("bookid") Integer bookId){
        String resoult = bookBorrowLogService.borrowBooks(userId, bookId);
        Books books = bookService.queryBook(bookId);
        if ("success"==resoult){
            return new UniversalResponseBody(0,"success",books);
        }
        return new UniversalResponseBody(404,resoult,null);
    }
    //搜索图书信息
    @RequestMapping("/{userid}/book/search={bookname}")
    public UniversalResponseBody bookSearch(@PathVariable("bookname") String bookName){
        List<BookInfo> bookInfoList = bookInfoService.getBookInfoByBookName(bookName);
        if (null!=bookInfoList.get(0)){
            return new UniversalResponseBody(0,"success",bookInfoList);
        }
        return new UniversalResponseBody(404,"error","列表为空");
    }

    //还书
    @RequestMapping("/{userid}/book/return={bookLogId}")
    public UniversalResponseBody bookReturn(@PathVariable("bookLogId") Integer logId){
        BookBorrowLog bookBorrowLog = bookBorrowLogService.queryBookLog(logId);
        Date returnTime = new Date();
        bookBorrowLog.setBookReturnTime(returnTime);
        //获取所还图书
        Books books = bookService.queryBook(bookBorrowLog.getBookId());
        //获取图书应还时间
        Date bookShouldReturnBefore = books.getBookShouldReturnBefore();
        if (bookShouldReturnBefore.after(returnTime)){
            System.out.println(11);
            books.setBookActiveStatus(1);
            books.setBookBorrowStatus(0);
            bookService.updateBook(books);
        }else {
            //TODO,超时处罚金？
        }
        //更新日志中还书时间
        bookBorrowLogService.updateBookLog(bookBorrowLog);
        return new UniversalResponseBody(0,"success","还书成功");
    }

}
