package com.lib.management.controller;

import com.lib.management.model.SuperAdmin;
import com.lib.management.service.SuperAdminService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SuperAdminController {
    @Resource
    private SuperAdminService superAdminService;

    @GetMapping("/admin/info")
    public UniversalResponseBody getSuperAdminInfoByName(String name){
        //在RestController后，方法返回的对象将会被自动解析成json数据
        SuperAdmin superAdmin = superAdminService.searchAccountByAdminName(name);
        if(superAdmin != null){
            return new UniversalResponseBody<>(0,"success",superAdmin);
        }else{
            return new UniversalResponseBody(-1,"error");
        }
    }
}
