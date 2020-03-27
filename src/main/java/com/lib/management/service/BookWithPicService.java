package com.lib.management.service;

import com.lib.management.dto.BookWithPic;

import java.util.List;
import java.util.Map;

public interface BookWithPicService {
    BookWithPic getBookById(int bookInfoId);

    List<BookWithPic> searchByBookName(String bookName,int page);

    List<BookWithPic> searchByMultiParams(Map<String,Object> map);
}
