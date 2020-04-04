package com.lib.management.mapper;

import com.lib.management.model.BookManager;

import java.util.Map;

public interface BookManagerMapper {
    int deleteByPrimaryKey(Integer bookManagerId);

    int insert(BookManager record);

    int insertSelective(BookManager record);

    BookManager selectByPrimaryKey(Integer bookManagerId);

    BookManager selectByManagerName(String bookManagerName);

    int updateByPrimaryKeySelective(BookManager record);

    int updateByPrimaryKey(BookManager record);

    int updateManagerStatus(Map<String,Object> paramsMap);

    void updateByAccountNameAndPassword(String name,String password, String newName);

    void initialAccountPassWordByName(String name);

    void deleteAccountByName(String name);
}