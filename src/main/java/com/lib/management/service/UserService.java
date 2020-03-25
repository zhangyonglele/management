package com.lib.management.service;

import com.lib.management.dto.UserHelper;
import com.lib.management.model.BookManager;
import com.lib.management.model.User;

import java.util.List;

public interface UserService {

    boolean addNewUser(User user);

    User getUserInfoByName(String name);

    boolean setUserInfoByUserID(Integer userID, UserHelper userHelper);

    List<User> getUninitReaderAccount(int page);

    boolean initReaderAccountByReaderId(int id,int initBy);
}
