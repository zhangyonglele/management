package com.lib.management.service;

import com.lib.management.model.BookManager;
import com.lib.management.model.User;

import java.util.List;

public interface UserService {
    User getUserInfoByName(String name);
    List<User> getUninitReaderAccount(int page);

    boolean initReaderAccountByReaderId(int id,int initBy);
}
