package com.lib.management.controller;

import com.lib.management.dto.BookForHistory;
import com.lib.management.service.BookHistoryService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class BookHistoryController {
    @Resource
    private BookHistoryService bookHistoryService;

    @GetMapping("/history/all/page/{page}")
    public UniversalResponseBody<BookForHistory> getAllBorrowHistory(@PathVariable("page")int page){
        return new UniversalResponseBody(0,"success",bookHistoryService.getAllHistory(page));
    }

    @GetMapping("/history/readerId/{readerId}/page/{page}")
    public UniversalResponseBody<BookForHistory> getHistoryByReaderId(@PathVariable("readerId")int readerId,@PathVariable("page")int page){
        return new UniversalResponseBody(0,"success",bookHistoryService.getHistoryByReaderId(page,readerId));
    }

}
