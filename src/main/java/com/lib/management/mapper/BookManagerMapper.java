package com.lib.management.mapper;

import com.lib.management.model.BookManager;

public interface BookManagerMapper {
    int deleteByPrimaryKey(Integer bookManagerId);

    int insert(BookManager record);

    int insertSelective(BookManager record);

    BookManager selectByPrimaryKey(Integer bookManagerId);

    int updateByPrimaryKeySelective(BookManager record);

    int updateByPrimaryKey(BookManager record);
}