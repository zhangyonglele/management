package com.lib.management.mapper;

import com.lib.management.model.LibrarianBroadcast;

public interface LibrarianBroadcastMapper {
    int deleteByPrimaryKey(Integer broadcastId);

    int insert(LibrarianBroadcast record);

    int insertSelective(LibrarianBroadcast record);

    LibrarianBroadcast selectByPrimaryKey(Integer broadcastId);

    int updateByPrimaryKeySelective(LibrarianBroadcast record);

    int updateByPrimaryKey(LibrarianBroadcast record);
}