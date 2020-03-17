package com.lib.management.service.serviceImpl;

import com.lib.management.dto.BookInfoResponse;
import com.lib.management.mapper.BookInfoResponseMapper;
import com.lib.management.service.BookInfoResponseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookInfoResponseServiceImpl implements BookInfoResponseService {
    @Resource
    private BookInfoResponseMapper bookInfoResponseMapper;

    @Override
    public BookInfoResponse getBookInfoByBookInfoId(int bookInfoId) {
        return bookInfoResponseMapper.selectBookInfoById(bookInfoId);
    }

    @Override
    public List<BookInfoResponse> getBooksInfoByBookName(String bookName) {
        return bookInfoResponseMapper.selectBooksInfoByBookName(bookName);
    }
}
