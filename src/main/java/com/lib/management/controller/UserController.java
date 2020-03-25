package com.lib.management.controller;

import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.model.User;
import com.lib.management.service.UserService;
import com.lib.management.util.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/reader/login")
    public UniversalResponseBody login(String userName, String password, HttpSession session){
        User user = userService.getUserInfoByName(userName);
        //permitStatus状态不影响登陆，影响后续的借书环节
        //也可以设置令其跳转到缴费页面
        if(user != null  && user.getUserStatus() == 1 && user.getUserPassword().equals(password)){
            session.setAttribute("auth","reader");
            session.setAttribute("userInfo",user);
            return new UniversalResponseBody(0,"success");
        }else{
            log.warn("[WARRING CHECK] userName "+userName+",password " +password);
            return new UniversalResponseBody(-1,"auth refuse");
        }
    }

    @PostMapping("/reader/logout")
    @LoginRequire("reader")
    public UniversalResponseBody logout(HttpSession session){
        session.invalidate();
        return new UniversalResponseBody(0,"success");
    }
}
