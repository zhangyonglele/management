package com.lib.management.service.serviceImpl;

import com.lib.management.dto.helper.BookManagerHelper;
import com.lib.management.mapper.BookManagerMapper;
import com.lib.management.model.BookManager;
import com.lib.management.service.BookManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public boolean registerForNewManager(BookManagerHelper bookManagerHelper) {
        BookManager manager = bookManagerHelper.toBookManager();
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
}
