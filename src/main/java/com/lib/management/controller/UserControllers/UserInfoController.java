package com.lib.management.controller.UserControllers;

import com.lib.management.service.UserInfoService;

import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class UserInfoController {
    @Resource
    private UserInfoService userService;

    @GetMapping("/readers/page/{page}")
    public UniversalResponseBody getAllReadersInfo(@PathVariable("page") int page){
        return new UniversalResponseBody(0,"success",userService.getUserByPage(page));
    }

    @GetMapping("/readers/keyword/{keyword}/{page}")
    public UniversalResponseBody getReaderByName(@PathVariable("keyword")String keyword,@PathVariable("page")int page){
        return new UniversalResponseBody(0,"success",userService.getUserInfoByNameSearch(keyword,page));
    }
}
