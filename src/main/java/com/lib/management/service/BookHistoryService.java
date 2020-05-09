package com.lib.management.service;

import com.lib.management.dto.BookForHistory;

import java.util.List;

public interface BookHistoryService {
    List<BookForHistory> getAllHistory(int page);

    List<BookForHistory> getHistoryByReaderId(int page,int readerId);
}
