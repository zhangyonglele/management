package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.BookInfoMapper;
import com.lib.management.model.BookInfo;
import com.lib.management.service.BookInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class BookInfoServiceImpl implements BookInfoService {
    @Resource
    private BookInfoMapper bookInfoMapper;

    @Override
    public boolean addNewBookInfo(BookInfo bookInfo) {
        boolean flag = false;
        try{
            bookInfoMapper.insert(bookInfo);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateBookInfo(BookInfo bookInfo) {
        return bookInfoMapper.updateByPrimaryKey(bookInfo) > 0;
    }

    @Override
    public BookInfo getBookInfoByBookName(String bookName) {
        return bookInfoMapper.selectByBookName(bookName);
    }

    @Override
    public boolean updateABookInfoStatus(int bookInfoId,int bookInfoStatus) {
        Map<String,Object> params = new HashMap<>();
        params.put("bookInfoStatus",bookInfoStatus);
        params.put("bookInfoId",bookInfoId);
        return bookInfoMapper.updateBookStatusById(params) > 0;
    }
}
