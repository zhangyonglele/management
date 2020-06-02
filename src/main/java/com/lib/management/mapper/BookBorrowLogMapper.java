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

    /**
     * 检查log中是否存在同一本书处于被借阅活跃状态
     * 即检查该书是否被借阅或者被预约
     * @param bookId 书本id
     * @return 返回如果为空，则为该书无活跃状态，可以被借阅，否则返回数字。
     */
    Integer selectLogIdForCheckDataBaseError(int bookId);

    BookBorrowLog selectByBookId(int bookId);

    Double getUserFine(User user);
}