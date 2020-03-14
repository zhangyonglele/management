package com.lib.management.service;

import com.lib.management.model.BookInfo;

public interface BookInfoService {
    boolean addNewBookInfo(BookInfo bookInfo);

    boolean updateBookInfo(BookInfo bookInfo);

    BookInfo getBookInfobByBookName(String bookName);

    boolean removeABookInfo(BookInfo bookInfo);
}
