package com.lib.management.service.unit.impl;

import com.lib.management.model.BookBorrowLog;
import com.lib.management.model.Books;
import com.lib.management.service.BookBorrowLogService;
import com.lib.management.service.BookService;
import com.lib.management.service.unit.BorrowBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {
    @Resource
    private BookService bookService;

    @Resource
    private BookBorrowLogService bookBorrowLogService;

    @Override
    public boolean borrowBook(int readerId, int bookId) {
        boolean flag = false;
        if(bookService.bookBorrow(readerId,bookId)){
            Books book = bookService.getBookByBookId(bookId);
            if(bookBorrowLogService.borrowLog(book)){
                flag = true;
            }
        }
        return flag;
    }
}
