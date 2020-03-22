package com.lib.management.service;

import com.lib.management.model.User;

import java.util.List;

public interface UserService {
    List<User> getUninitReaderAccount(int page);

    boolean initReaderAccountByReaderId(int id,int initBy);
}
