package com.lib.management.mapper;

import com.lib.management.model.SuperAdmin;

public interface SuperAdminMapper {
    int deleteByPrimaryKey(Integer superAdminId);

    int insert(SuperAdmin record);

    int insertSelective(SuperAdmin record);

    SuperAdmin selectByPrimaryKey(Integer superAdminId);

    SuperAdmin selectByAdminName(String adminName);

    int updateByPrimaryKeySelective(SuperAdmin record);

    int updateByPrimaryKey(SuperAdmin record);
}