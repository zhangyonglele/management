package com.lib.management.service;

import com.lib.management.model.User;

import java.util.List;

public interface UserInfoService {
    List<User> getUserInfoByNameSearch(String userName,int page);

    List<User> getUserByPage(int page);
}
