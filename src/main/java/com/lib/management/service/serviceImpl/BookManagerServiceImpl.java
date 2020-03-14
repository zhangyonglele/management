package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.BookManagerMapper;
import com.lib.management.model.BookManager;
import com.lib.management.service.BookManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookManagerServiceImpl implements BookManagerService {
    @Resource
    BookManagerMapper bookManagerMapper;

    @Override
    public BookManager getBookManagerInfoByName(String name) {
        BookManager bookManager = bookManagerMapper.selectByManagerName(name);
        if(bookManager.getBookManagerName().equals("")){
            return null;
        }else{
            return bookManager;
        }
    }
}
