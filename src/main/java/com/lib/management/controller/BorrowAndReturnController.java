package com.lib.management.controller;

import com.lib.management.service.unit.BorrowBookService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class BorrowAndReturnController {
    @Resource
    private BorrowBookService borrowBookService;

    @PutMapping("/book/{bookId}/reader/{readerId}")
    public UniversalResponseBody<Object> borrowBook(@PathVariable("bookId")int bookId,
                                                    @PathVariable("readerId")int readerId){
        if(borrowBookService.borrowBook(readerId,bookId)){
            return new UniversalResponseBody<>(0,"success");
        }else {
            return new UniversalResponseBody<>(-1, "error");
        }
    }


}
