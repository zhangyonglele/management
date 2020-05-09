package com.lib.management.service.serviceImpl;

import com.lib.management.dto.BookForHistory;
import com.lib.management.mapper.BookForHistoryMapper;
import com.lib.management.service.BookHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookHistoryServiceImpl implements BookHistoryService {
    @Resource
    private BookForHistoryMapper bookForHistoryMapper;

    @Override
    public List<BookForHistory> getAllHistory(int page) {
        return bookForHistoryMapper.getAllBorrowHistory((page-1)*10);
    }

    @Override
    public List<BookForHistory> getHistoryByReaderId(int page, int readerId) {
        Map<String,Object> params = new HashMap<>();
        params.put("page",(page-1)*10);
        params.put("readerId",readerId);
        return bookForHistoryMapper.getBorrowHistoryByReaderId(params);
    }
}
