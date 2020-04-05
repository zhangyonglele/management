package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.BookPositionDao;
import com.lib.management.service.BookPositionService;
import com.lib.management.dto.BookPosition;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookPositionServiceImpl implements BookPositionService {
    @Resource
    private BookPositionDao bookPositionDao;

    @Override
    public List<BookPosition> getBookPositionByBookInfoId(int bookInfoId, int page) {
        Map<String,Object> params = new HashMap<>();
        params.put("pageNumber",(page-1) * 10);
        params.put("bookInfoId",bookInfoId);
        return bookPositionDao.selectBookByBookInfoId(params);
    }
}
