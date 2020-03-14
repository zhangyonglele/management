package com.lib.management.controller;

import com.lib.management.model.BookManager;
import com.lib.management.service.BookManagerService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class BookManagerController {
    @Resource
    private BookManagerService bookManagerService;

//    @GetMapping()
//    public UniversalResponseBody login(String userName, String password, HttpSession session){
//        BookManager bookManager = bookManagerService.getBookManagerInfoByName(userName);
//        if(!userName.equals("")){
//            //session.
//        }
//    }

}
