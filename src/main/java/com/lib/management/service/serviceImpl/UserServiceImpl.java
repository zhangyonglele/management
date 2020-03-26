package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.BookBorrowLogMapper;
import com.lib.management.mapper.UserMapper;
import com.lib.management.model.BookBorrowLog;
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
    public User alterPersonInfo(User user) {
        userMapper.updateByPrimaryKey(user);
        User user1 = userMapper.selectByPrimaryKey(user.getUserId());
        BookBorrowLog bookBorrowLog = bookBorrowLogMapper.selectByPrimaryKey(1);
        System.out.println(bookBorrowLog);
        return user1;
    }
    //修改用户信息

}
