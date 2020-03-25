package com.lib.management.dto;

import com.lib.management.model.User;
import lombok.Data;

@Data
public class UserHelper {
    private Integer userId;

    private String userName;

    private String userPassword;

    public User toUser(){
        User user = new User();

        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserPassword(userPassword);

        return user;
    }
}
