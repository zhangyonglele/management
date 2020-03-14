package com.lib.management.mapper;

import com.lib.management.model.BookType;

public interface BookTypeMapper {
    int deleteByPrimaryKey(Integer bookTypeId);

    int insert(BookType record);

    int insertSelective(BookType record);

    BookType selectByPrimaryKey(Integer bookTypeId);

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);
}