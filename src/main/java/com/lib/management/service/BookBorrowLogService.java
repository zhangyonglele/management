package com.lib.management.service;

import com.lib.management.model.BookBorrowLog;
import com.lib.management.model.Books;

public interface BookBorrowLogService {
    //查询借书记录
    BookBorrowLog queryBookLog(Integer bookLogId);
    //更新日志信息
    Integer updateBookLog(BookBorrowLog bookBorrowLog);

    boolean borrowLog(Books book);

    //boolean checkAndRefresh

    boolean returnBookLog(int bookId);
}