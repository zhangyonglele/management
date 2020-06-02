package com.lib.management.mapper;

import com.lib.management.model.AdminConstData;

import java.math.BigDecimal;
import java.util.Date;

public interface AdminConstDataMapper {
    int deleteByPrimaryKey(String constKey);

    int insert(AdminConstData record);

    int insertSelective(AdminConstData record);

    AdminConstData selectByPrimaryKey(String constKey);

    int updateByPrimaryKeySelective(AdminConstData record);

    int updateByPrimaryKey(String constKey, BigDecimal constValue);

    int updateByPrimaryKey(String constKey, BigDecimal constValue, int updateBy, Date updateTime);
}