package com.lib.management.controller;

import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.model.User;
import com.lib.management.service.UserService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author:guan
 * @2020/3/25 15:01
 * 文件信息：
 */
@RestController
public class ReaderInfoController {
    @Resource
    private UserService readerService;
    @RequestMapping("/reader/info")
    //@LoginRequire("reader")
    public UniversalResponseBody alterPersonInfo(HttpSession session){
        User readerOld = (User) session.getAttribute("readerInfo");
        if(null!=readerOld){
            User readerNew = readerService.alterPersonInfo(readerOld);
            session.setAttribute("readerInfo",readerNew);
            return new UniversalResponseBody(0,"success",readerNew);
        }
        return new UniversalResponseBody(404,"error",null);
    }

}
