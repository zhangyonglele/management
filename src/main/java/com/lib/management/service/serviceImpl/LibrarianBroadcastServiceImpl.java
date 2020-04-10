package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.LibrarianBroadcastMapper;
import com.lib.management.model.LibrarianBroadcast;
import com.lib.management.service.LibrarianBroadcastService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LibrarianBroadcastServiceImpl implements LibrarianBroadcastService {
    @Resource
    private LibrarianBroadcastMapper broadcastMapper;

    @Override
    public boolean addNewBroadcast(LibrarianBroadcast broadcast) {
        boolean flag = false;
        try {
            broadcastMapper.insert(broadcast);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateBroadcast(LibrarianBroadcast broadcast) {
        boolean flag = false;
        try{
            broadcastMapper.updateByPrimaryKey(broadcast);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
