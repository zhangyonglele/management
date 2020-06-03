package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.UserMapper;
import com.lib.management.model.User;
import com.lib.management.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserInfoByNameSearch(String userName,int page) {
        Map<String ,Object> map = new HashMap<>();
        map.put("keyword",userName);
        map.put("page",(page - 1)*10);
        return userMapper.selectToSearchUserByName(map);
    }

    @Override
    public List<User> getUserByPage(int page) {
        return userMapper.selectAllUserByPageDESC((page - 1)*10);
    }
}
