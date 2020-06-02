package com.lib.management.controller;

import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.service.BookLogService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class ControlLogController {
    @Resource
    private BookLogService bookLogService;

    @GetMapping("/log/control/{page}")
    @LoginRequire("librarian")
    public UniversalResponseBody getLogByPage(@PathVariable("page")int page){
        return new UniversalResponseBody(0,"success",bookLogService.getControlLogByPage(page));
    }
}
