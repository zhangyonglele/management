package com.lib.management.service;

import com.lib.management.dto.BookPosition;

import java.util.List;

public interface BookPositionService {
    List<BookPosition> getBookPositionByBookInfoId(int bookInfoId,int page);
}
