package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.SuperAdminMapper;
import com.lib.management.model.SuperAdmin;
import com.lib.management.service.SuperAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.cert.TrustAnchor;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    @Resource
    private SuperAdminMapper superAdminMapper;

    @Override
    public SuperAdmin searchAccountByAdminName(String name) {
        SuperAdmin superAdmin = superAdminMapper.selectByAdminName(name);
        if(superAdmin == null){
            return null;
        }
        return superAdmin;
    }

    @Override
    public boolean updateAccountByAdminName(String name, String password) {
        boolean flag = false;
        try {
            superAdminMapper.updateByName(name,password);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
