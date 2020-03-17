package com.lib.management.mapper;

import com.lib.management.dto.BookInfoResponse;

import java.util.List;

public interface BookInfoResponseMapper {
    BookInfoResponse selectBookInfoById(int bookInfoId);

    List<BookInfoResponse> selectBooksInfoByBookName(String bookName);
}
