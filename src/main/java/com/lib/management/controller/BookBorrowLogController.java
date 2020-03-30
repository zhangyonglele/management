package com.lib.management.controller;

import com.lib.management.model.BookBorrowLog;
import com.lib.management.model.Books;
import com.lib.management.service.BookBorrowLogService;
import com.lib.management.service.BookInfoService;
import com.lib.management.service.BookService;
import com.lib.management.service.unit.BorrowBookService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

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
    private BookService bookService;

    @Resource
    private BorrowBookService borrowBookService;


    @PostMapping("/{userid}/book/borrow/{bookid}")
    @Transactional
    public UniversalResponseBody<Object> bookBorrow(@PathVariable("userid") int userId,
                                            @PathVariable("bookid") int bookId){
        if(borrowBookService.borrowBook(userId,bookId)) {
            return new UniversalResponseBody<>(0, "success");
        }else{
            return new UniversalResponseBody<>(-1,"error");
        }
    }


    //还书
    @PutMapping("/{userid}/book/{bookLogId}")
    public UniversalResponseBody bookReturn(@PathVariable("bookLogId") Integer logId){
        BookBorrowLog bookBorrowLog = bookBorrowLogService.queryBookLog(logId);
        Date returnTime = new Date();
        bookBorrowLog.setBookReturnTime(returnTime);
        //获取所还图书
        Books books = bookService.getBookByBookId(bookBorrowLog.getBookId());
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
