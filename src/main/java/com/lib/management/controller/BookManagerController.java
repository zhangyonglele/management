package com.lib.management.controller;

import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.model.BookManager;
import com.lib.management.service.BookManagerService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class BookManagerController {
    @Resource
    private BookManagerService bookManagerService;

    @PostMapping("/librarian/login")
    public UniversalResponseBody login(String userName, String password, HttpSession session){
        BookManager bookManager = bookManagerService.getBookManagerInfoByName(userName);
        if(bookManager != null  && bookManager.getBookManagerPassword().equals(password)){
            session.setAttribute("auth","librarian");
            session.setAttribute("userInfo",bookManager);
            return new UniversalResponseBody(0,"success");
        }else{
            return new UniversalResponseBody(-1,"auth refuse");
        }
    }

    @PostMapping("/librarian/logout")
    @LoginRequire("librarian")
    public UniversalResponseBody logout(HttpSession session){
        session.invalidate();
        return new UniversalResponseBody(0,"success");
    }

}
