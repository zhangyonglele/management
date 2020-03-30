package com.lib.management.service;

import com.lib.management.model.BookBorrowLog;

public interface BookBorrowLogService {
    //借阅图书
    String borrowBooks(Integer readerId, Integer bookId);
    //查询借书记录
    BookBorrowLog queryBookLog(Integer bookLogId);
    //更新日志信息
    Integer updateBookLog(BookBorrowLog bookBorrowLog);
}