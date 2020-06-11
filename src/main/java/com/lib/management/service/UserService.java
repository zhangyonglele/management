package com.lib.management.service;

import com.lib.management.dto.UserInfoHelper;
import com.lib.management.model.User;

import java.util.List;

public interface UserService {

    boolean addNewUser(User user);

    User getUserInfoByName(String name);

    boolean setUserInfoByUserID(Integer userID, UserInfoHelper userInfoHelper);

    User getUserInfoByUserId(int userId);

    List<User> getUninitReaderAccount(int page);

    boolean initReaderAccountByReaderId(int id,int initBy);
    //修改用户个人信息
    boolean alterPersonInfo(User user);

    Double getUserFine(User user);

    List<String> getUserFavoriteBook(String userId);

    boolean addFavoriteBook(User user, Integer bookInfoId);

    boolean  deleteUserInfo(int userId);
}
