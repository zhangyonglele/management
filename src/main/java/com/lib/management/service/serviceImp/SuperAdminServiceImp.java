package com.lib.management.service.serviceImp;

import com.lib.management.mapper.SuperAdminMapper;
import com.lib.management.model.SuperAdmin;
import com.lib.management.service.SuperAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SuperAdminServiceImp implements SuperAdminService {
    @Resource
    private SuperAdminMapper superAdminMapper;

    @Override
    public SuperAdmin searchAccountByAdminName(String name) {
        SuperAdmin superAdmin = superAdminMapper.selectByAdminName(name);
        if(superAdmin.getSuperAdminName().equals("")){
            return null;
        }
        return superAdmin;
    }
}
