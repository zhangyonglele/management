package com.lib.management.service.unit.impl;

import com.lib.management.model.Books;
import com.lib.management.service.BookBorrowLogService;
import com.lib.management.service.BookService;
import com.lib.management.service.unit.ReturnBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ReturnBookServiceImpl implements ReturnBookService {
    @Resource
    private BookService bookService;

    @Resource
    private BookBorrowLogService bookBorrowLogService;

    @Override
    @Transactional
    public boolean returnBookRequest(int bookId) {
        if(bookService.makeBookWaitingForResetPosition(bookId)){
            if(bookBorrowLogService.returnBookLog(bookId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean resetBookPosition(int bookId, int room,int sheet,int level) {
        if(bookService.setBookReturn(bookId,room,sheet,level)){
            return true;
        }else {
            return false;
        }
    }
}
