package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.BookInfoMapper;
import com.lib.management.model.BookInfo;
import com.lib.management.service.BookInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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
        return bookInfoMapper.updateByPrimaryKeySelective(bookInfo) > 0;
    }

    @Override
    public List<BookInfo> getBookInfoByBookName(String bookName) {
        return bookInfoMapper.selectByBookName(bookName);
    }

    @Override
    public BookInfo getBookInfoById(int id) {
        return bookInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateABookInfoStatus(int bookInfoId,int bookInfoStatus) {
        if(bookInfoMapper.selectByPrimaryKey(bookInfoId).getBookCopyNumber() > 0){
            return false;
        }
        Map<String,Object> params = new HashMap<>();
        params.put("bookInfoStatus",bookInfoStatus);
        params.put("bookInfoId",bookInfoId);
        return bookInfoMapper.updateBookStatusById(params) > 0;
    }
}
