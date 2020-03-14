package com.lib.management.mapper;

import com.lib.management.model.BookInfo;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer bookInfoId);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer bookInfoId);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);
}