package com.lib.management.mapper;

import com.lib.management.model.FavoriteBook;

import java.util.List;

public interface FavoriteBookMapper {
    int deleteByPrimaryKey(FavoriteBook key);

    int insert(FavoriteBook record);

    int insertSelective(FavoriteBook record);

    List<String> getUserFavoriteBook(String userId);
}