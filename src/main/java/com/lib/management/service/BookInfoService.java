package com.lib.management.service;

import com.lib.management.model.BookInfo;

public interface BookInfoService {
    boolean addNewBookInfo(BookInfo bookInfo);

    boolean updateBookInfo(BookInfo bookInfo);

    BookInfo getBookInfoByBookName(String bookName);

    boolean updateABookInfoStatus(int bookInfoId,int bookInfoStatus);
}
