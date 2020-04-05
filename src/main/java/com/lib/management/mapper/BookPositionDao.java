package com.lib.management.mapper;

import com.lib.management.dto.BookPosition;

import java.util.List;
import java.util.Map;

public interface BookPositionDao {
    List<BookPosition> selectBookByBookInfoId(Map<String,Object> params);
}