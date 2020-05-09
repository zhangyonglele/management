package com.lib.management.mapper;

import com.lib.management.dto.BookForHistory;

import java.util.List;
import java.util.Map;

public interface BookForHistoryMapper {

    List<BookForHistory> getAllBorrowHistory(int page);

    List<BookForHistory> getBorrowHistoryByReaderId(Map<String,Object> params);
}