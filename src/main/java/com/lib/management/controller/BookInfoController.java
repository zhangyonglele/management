package com.lib.management.controller;

import com.lib.management.model.BookInfo;
import com.lib.management.service.BookInfoService;
import com.lib.management.util.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class BookInfoController {
    @Resource
    private BookInfoService bookInfoService;

    @PostMapping("/book/info")
    public UniversalResponseBody addNewBookInfo(BookInfo bookInfo){
        log.info("post func");
        return new UniversalResponseBody(0,"message");
    }

    @GetMapping("/book/info")
    public UniversalResponseBody getBookInfoById(@RequestParam("bookid") int bookId){
        log.info("get func");
        return new UniversalResponseBody(0,"memm");
    }

    @PutMapping("/book/info")
    public UniversalResponseBody updateBookInfoById(BookInfo bookInfo){

        return new UniversalResponseBody(0,"mess");
    }
}
