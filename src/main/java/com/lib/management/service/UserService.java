package com.lib.management.service;

import com.lib.management.model.BookBorrowLog;
import com.lib.management.model.User;

import java.util.List;

public interface UserService {
    List<User> getUninitReaderAccount(int page);

    boolean initReaderAccountByReaderId(int id,int initBy);

    //修改用户个人信息
    User alterPersonInfo(User user);
}
