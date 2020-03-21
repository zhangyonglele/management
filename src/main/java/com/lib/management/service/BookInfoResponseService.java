package com.lib.management.service;

import com.lib.management.dto.BookInfoResponse;

import java.util.List;

public interface BookInfoResponseService {
    BookInfoResponse getBookInfoByBookInfoId(int bookInfoId);

    List<BookInfoResponse> getBooksInfoByBookName(String bookName,int page);
}
