package com.lib.management.controller;

import com.lib.management.dto.BookManagerHelper;
import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.model.BookManager;
import com.lib.management.model.SuperAdmin;
import com.lib.management.service.BookManagerService;
import com.lib.management.service.SuperAdminService;
import com.lib.management.util.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/admin")
public class SuperAdminController {
    @Resource
    private SuperAdminService superAdminService;

    @Resource
    private BookManagerService bookManagerService;


    @GetMapping("/login")
    public UniversalResponseBody superAdminLogin(String name,String password, HttpSession session){
        SuperAdmin admin = superAdminService.searchAccountByAdminName(name);
        if(admin != null && admin.getSuperAdminPassword().equals(password)){
            session.setAttribute("auth","superAdmin");
            session.setAttribute("adminInfo",admin);
            return new UniversalResponseBody(0,"success");
        }else {
            log.warn("[WARRING CHECK] userName "+name+",password " +password);
            return new UniversalResponseBody(-1,"error");
        }
    }
    @GetMapping("/logout")
    @LoginRequire("superAdmin")
    public UniversalResponseBody superAdminLogout(HttpSession session){
        session.invalidate();
        return new UniversalResponseBody(0,"success");
    }

    @PutMapping("/password")
    @LoginRequire("superAdmin")
    public UniversalResponseBody updatePassword(String name,String oldPwd, String newPwd, String newPwdRep,
    HttpSession session){
        if(!newPwd.equals(newPwdRep)){
            log.warn("[WARRING CHECK] newPassword "+newPwd + " newPasswordREP " +newPwdRep);
            return new UniversalResponseBody(-1,"error");
        }
        SuperAdmin superAdmin = superAdminService.searchAccountByAdminName(name);
        if(superAdmin != null && superAdmin.getSuperAdminPassword().equals(oldPwd)){
            if(superAdminService.updateAccountByAdminName(name,newPwd))
                return new UniversalResponseBody(0,"success");
            else {
                return new UniversalResponseBody(-1,"error");
            }
        }else {
            log.warn("[WARRING CHECK] userName "+name+",password " +oldPwd);
            return new UniversalResponseBody(-1,"error");
        }
    }

    //修改管理员账号名称
    @PutMapping("/bookmanager")
    //@LoginRequire("superAdmin")
    public UniversalResponseBody updateName(String name,String password,String nameRep,HttpSession session){
        if(name.equals(nameRep)){
            log.warn("[WARRING CHECK] name"+name+" newName"+nameRep);
            return new UniversalResponseBody(-1,"error");
        }
        if(bookManagerService.changeManagerAccountName(name,password,nameRep)){
            return new UniversalResponseBody(0,"success");
        }else {
            log.info("[WARRING CHECK] name"+name+" password"+password);
            return new UniversalResponseBody(-1,"error");
        }
    }

    //注册图书管理员账号
    @PostMapping("/bookmanager")
    @LoginRequire("superAdmin")
    public UniversalResponseBody registerManager(String name,String pwd, String pwdRep, HttpSession session){

        if(!pwd.equals(pwdRep)){
            log.info("[WARRING CHECK] newPassword "+pwd + " newPasswordREP " +pwdRep);
            return new UniversalResponseBody(-1,"error");
        }
        BookManagerHelper bookManagerHelper = new BookManagerHelper(name,pwd);
        if(bookManagerService.registerForNewManager(bookManagerHelper)){
            return new UniversalResponseBody(0,"success");
        }else
            return new UniversalResponseBody(-1,"error");

    }

    //初始化管理员账号密码
    @PutMapping("/bookmanager/password")
    @LoginRequire("superAdmin")
    public UniversalResponseBody initialManagerPassword(String name){
        if(bookManagerService.initialManagerAccount(name)){
            return new UniversalResponseBody(0,"success");
        }else {
            log.info("[WARN CHECK "+name);
            return new UniversalResponseBody(-1,"error");
        }
    }

    //删除管理员账号
    @DeleteMapping("/bookmanager")
    @LoginRequire("superAdmin")
    public UniversalResponseBody deleteAccount(String name){
        if(bookManagerService.deleteAccount(name)){
            return new UniversalResponseBody(0,"success");
        }else {
            log.info("[WARN CHECK] "+name);
            return new UniversalResponseBody(-1,"error");
        }
    }

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
