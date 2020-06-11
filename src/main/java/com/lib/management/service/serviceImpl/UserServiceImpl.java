package com.lib.management.service.serviceImpl;

import com.lib.management.dto.UserHelper;
import com.lib.management.dto.UserInfoHelper;
import com.lib.management.mapper.BookBorrowLogMapper;
import com.lib.management.mapper.FavoriteBookMapper;
import com.lib.management.mapper.UserMapper;
import com.lib.management.model.FavoriteBook;
import com.lib.management.model.User;
import com.lib.management.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private BookBorrowLogMapper bookBorrowLogMapper;

    @Resource
    private FavoriteBookMapper favoriteBookMapper;

    @Override
    public boolean addNewUser(User user) {
        boolean flag = false;
        try{
            userMapper.insert(user);
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User getUserInfoByName(String name) {
        return userMapper.selectByUserName(name);
    }

    @Override
    public boolean setUserInfoByUserID(Integer userID, UserInfoHelper userInfoHelper) {
        User user = userInfoHelper.toUser();
        user.setUserId(userID);
        if(userMapper.updateByPrimaryKeySelective(user)>0)
           return true;
        else
           return false;
    }

    @Override
    public List<User> getUninitReaderAccount(int page) {
        return userMapper.selectUninitReadersAccount((page-1)*10);
    }

    @Override
    public boolean initReaderAccountByReaderId(int id,int initBy) {
        User uninitReader = userMapper.selectByPrimaryKey(id);
        if(uninitReader == null || uninitReader.getPermitStatus() == 0 || uninitReader.getUserStatus() == 1){
            return false;
        }else{
            uninitReader.setCreateBy(initBy);
            uninitReader.setUserStatus(1);
            if(userMapper.updateByPrimaryKeySelective(uninitReader) > 0){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public User getUserInfoByUserId(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    //修改用户信息
    @Override
    public boolean alterPersonInfo(User user) {
        boolean flag = false;
        try {
            userMapper.updateByPrimaryKey(user);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean deleteUserInfo(int userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setUserStatus(0);
        boolean flag = false;
        try {
            int ret = userMapper.updateByPrimaryKey(user);
            if(ret > 0){
                flag = true;
            }else {
                flag = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Double getUserFine(User user) {
        return bookBorrowLogMapper.getUserFine(user);
    }

    @Override
    public List<String> getUserFavoriteBook(String userId) {
        return favoriteBookMapper.getUserFavoriteBook(userId);
    }

    @Override
    public boolean addFavoriteBook(User user, Integer bookInfoId) {
        FavoriteBook record = new FavoriteBook();
        record.setBookInfoId(bookInfoId);
        record.setUserId(user.getUserId());

        try{
            if(favoriteBookMapper.insert(record)==1)
                return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}
