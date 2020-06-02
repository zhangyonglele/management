package com.lib.management.mapper;

import com.lib.management.model.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByUserName(String name);

    List<User> selectUninitReadersAccount(int pageNumber);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUserRegisterByDate(Map<String,Object> data);
}