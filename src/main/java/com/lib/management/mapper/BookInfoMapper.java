package com.lib.management.mapper;

import com.lib.management.model.BookInfo;

import java.util.Map;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer bookInfoId);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByBookName(String bookName);

    BookInfo selectByPrimaryKey(Integer bookInfoId);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

    int updateBookStatusById(Map<String,Object> params);
}