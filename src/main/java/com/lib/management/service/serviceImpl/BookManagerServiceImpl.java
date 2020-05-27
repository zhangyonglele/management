package com.lib.management.service.serviceImpl;

import com.lib.management.dto.BookManagerHelper;
import com.lib.management.mapper.BookManagerMapper;
import com.lib.management.model.BookManager;
import com.lib.management.service.BookManagerService;
import com.lib.management.util.MyDateFormat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookManagerServiceImpl implements BookManagerService {
    @Resource
    BookManagerMapper bookManagerMapper;

    @Override
    public BookManager getBookManagerInfoByName(String name) {
        return bookManagerMapper.selectByManagerName(name);
    }

    @Override
    public boolean changeManagerAccountStatus(String userName,int futureStatus) {
        Map<String,Object> params = new HashMap<>();
        params.put("bookManagerName",userName);
        params.put("futureStatus",futureStatus);
        return bookManagerMapper.updateManagerStatus(params) > 0;
    }

    @Override
    public boolean registerForNewManager (BookManagerHelper bookManagerHelper) {
        BookManager manager = bookManagerHelper.toBookManager();
        String date = MyDateFormat.dateFormat.format(new Date());
        try {
            manager.setCreateTime(MyDateFormat.dateFormat.parse(date));
        }catch (Exception e){
            e.printStackTrace();
        }
        manager.setActiveStatus(0);
        boolean flag = false;
        try{
            bookManagerMapper.insert(manager);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean changeManagerAccountName(String name,String password, String newName) {
        boolean flag = false;
        try {
            if(bookManagerMapper.updateByAccountNameAndPassword(name,password,newName) > 0){
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean initialManagerAccount(String name) {
        boolean flag = false;
        try {
            if(bookManagerMapper.initialAccountPassWordByName(name) > 0)
                flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteAccount(String name) {
        boolean flag = false;
        try {
            if(bookManagerMapper.deleteAccountByName(name) > 0)
                flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
