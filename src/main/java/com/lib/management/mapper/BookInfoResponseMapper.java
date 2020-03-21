package com.lib.management.mapper;

import com.lib.management.dto.BookInfoResponse;

import java.util.List;
import java.util.Map;

public interface BookInfoResponseMapper {
    BookInfoResponse selectBookInfoById(int bookInfoId);

    List<BookInfoResponse> selectBooksInfoByBookName(Map<String,Object> data);

    List<BookInfoResponse> searchBy(Map<String,Object> searchParams);
}
