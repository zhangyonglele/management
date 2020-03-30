package com.lib.management.mapper;

import com.lib.management.model.BookType;

import java.util.List;

public interface BookTypeMapper {
    int deleteByPrimaryKey(Integer bookTypeId);

    int insert(BookType record);

    int insertSelective(BookType record);

    BookType selectByPrimaryKey(Integer bookTypeId);

    List<BookType> selectAllType();

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);

    int removeType(int typeId);
}