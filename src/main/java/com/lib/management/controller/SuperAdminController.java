package com.lib.management.controller;

import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.model.SuperAdmin;
import com.lib.management.service.SuperAdminService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class SuperAdminController {
    @Resource
    private SuperAdminService superAdminService;

    @GetMapping("/admin/info")
    public UniversalResponseBody getSuperAdminInfoByName(String name,HttpSession session){
        //在RestController后，方法返回的对象将会被自动解析成json数据
        SuperAdmin superAdmin = superAdminService.searchAccountByAdminName(name);

        if(superAdmin != null){
            //添加角色参数
            session.setAttribute("auth","superAdmin");
            return new UniversalResponseBody<>(0,"success",superAdmin);
        }else{
            return new UniversalResponseBody(-1,"error");
        }
    }

    @GetMapping("/admin/getinfo")
    @LoginRequire("superAdmin")//在本注解的参数中放入对应需要角色的参数
    public UniversalResponseBody getInfo(HttpSession session){
        return new UniversalResponseBody<>(0,"success",(SuperAdmin)session.getAttribute("test"));
    }
}
