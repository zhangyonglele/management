package com.lib.management.service.serviceImpl;

import com.lib.management.dto.BookInfoResponse;
import com.lib.management.mapper.BookInfoResponseMapper;
import com.lib.management.service.BookInfoResponseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookInfoResponseServiceImpl implements BookInfoResponseService {
    @Resource
    private BookInfoResponseMapper bookInfoResponseMapper;

    @Override
    public BookInfoResponse getBookInfoByBookInfoId(int bookInfoId) {
        return bookInfoResponseMapper.selectBookInfoById(bookInfoId);
    }

    @Override
    public List<BookInfoResponse> getBooksInfoByBookName(String bookName,int page) {
        Map<String,Object> map = new HashMap<>();
        map.put("bookName",bookName);
        map.put("pageNumber",(page-1) * 17);
        return bookInfoResponseMapper.selectBooksInfoByBookName(map);
    }
}
