package com.lib.management.dto;

import com.lib.management.model.User;
import lombok.Data;

/**
 * a view in database
 */
@Data
public class UserInfoHelper {
    private Integer userId;

    private String userName;

    public UserInfoHelper(){}

    public UserInfoHelper(User user){
        userId = user.getUserId();
        userName = user.getUserName();
    }

    public User toUser(){
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);

        return user;
    }
}
