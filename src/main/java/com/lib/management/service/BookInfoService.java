package com.lib.management.service;

import com.lib.management.model.BookInfo;

import java.util.List;

public interface BookInfoService {
    boolean addNewBookInfo(BookInfo bookInfo);

    boolean updateBookInfo(BookInfo bookInfo);

    List<BookInfo> getBookInfoByBookName(String bookName);

    BookInfo getBookInfoById(int id);

    boolean updateABookInfoStatus(int bookInfoId,int bookInfoStatus);


}
