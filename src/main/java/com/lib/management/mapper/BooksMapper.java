package com.lib.management.mapper;

import com.lib.management.model.Books;

import java.util.List;

public interface BooksMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Books record);

    int insertSelective(Books record);

    Books selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);
    Books selectByBookInfoId(Integer bookInfoId);
}