package com.lib.management.service;

import com.lib.management.dto.BookInfoResponse;

import java.util.List;
import java.util.Map;


/**
 * 功能淘汰，新功能请使用
 */
public interface BookInfoResponseService {
    BookInfoResponse getBookInfoByBookInfoId(int bookInfoId);

    List<BookInfoResponse> getBooksInfoByBookName(String bookName,int page);

    List<BookInfoResponse> searchByMultParams(Map<String,Object> params);
}
