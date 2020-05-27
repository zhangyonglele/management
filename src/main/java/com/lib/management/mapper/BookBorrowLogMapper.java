package com.lib.management.mapper;

import com.lib.management.model.BookBorrowLog;
import com.lib.management.model.User;

public interface BookBorrowLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(BookBorrowLog record);

    int insertSelective(BookBorrowLog record);

    BookBorrowLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(BookBorrowLog record);

    int updateByPrimaryKey(BookBorrowLog record);

    int selectLogIdForCheckDataBaseError(int bookId);

    BookBorrowLog selectByBookId(int bookId);

    Double getUserFine(User user);
}