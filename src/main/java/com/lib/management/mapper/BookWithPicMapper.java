package com.lib.management.mapper;

import com.lib.management.dto.BookWithPic;

import java.util.List;
import java.util.Map;

public interface BookWithPicMapper {
    BookWithPic selectBookByBookInfoId(Integer bookInfoId);

    List<BookWithPic> selectBookByName(Map<String,Object> params);

    List<BookWithPic> selectBookBy(Map<String,Object> multiParams);
}