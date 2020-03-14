package com.lib.management.mapper;

import com.lib.management.model.BookControlLog;

public interface BookControlLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(BookControlLog record);

    int insertSelective(BookControlLog record);

    BookControlLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(BookControlLog record);

    int updateByPrimaryKey(BookControlLog record);
}