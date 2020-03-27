package com.lib.management.service.serviceImpl;

import com.lib.management.dto.BookWithPic;
import com.lib.management.mapper.BookWithPicMapper;
import com.lib.management.service.BookWithPicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookWithPicServiceImpl implements BookWithPicService {
    @Resource
    private BookWithPicMapper bookWithPicMapper;

    @Override
    public BookWithPic getBookById(int bookInfoId) {
        return bookWithPicMapper.selectBookByBookInfoId(bookInfoId);
    }

    @Override
    public List<BookWithPic> searchByBookName(String bookName, int page) {
        Map<String,Object> map = new HashMap<>();
        map.put("bookName",bookName);
        map.put("pageNumber",(page - 1) * 17);
        return bookWithPicMapper.selectBookByName(map);
    }

    @Override
    public List<BookWithPic> searchByMultiParams(Map<String, Object> map) {
        return bookWithPicMapper.selectBookBy(map);
    }
}
