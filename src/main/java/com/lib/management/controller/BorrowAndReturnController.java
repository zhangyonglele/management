package com.lib.management.controller;

import com.lib.management.service.unit.BorrowBookService;
import com.lib.management.service.unit.ReturnBookService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class BorrowAndReturnController {
    @Resource
    private BorrowBookService borrowBookService;

    @Resource
    private ReturnBookService returnBookService;

    @PutMapping("/book/{bookId}/reader/{readerId}")
    public UniversalResponseBody<Object> borrowBook(@PathVariable("bookId")int bookId,
                                                    @PathVariable("readerId")int readerId){
        if(borrowBookService.borrowBook(readerId,bookId)){
            return new UniversalResponseBody<>(0,"success");
        }else {
            return new UniversalResponseBody<>(-1, "error");
        }
    }

    @PutMapping("/book/req/{bookId}")
    public UniversalResponseBody<Object> bookReturnRequest(@PathVariable("bookId")int bookId){
        if(returnBookService.returnBookRequest(bookId)){
            return new UniversalResponseBody<>(0,"success");
        }else{
            return new UniversalResponseBody<>(-1, "error");
        }
    }

    @PutMapping("/book/reset/{bookId}")
    public UniversalResponseBody<Object> bookResetPosition(@PathVariable("bookId")int bookId,
                                                           @RequestParam("room") int room,
                                                           @RequestParam("sheet")int sheet,
                                                           @RequestParam("layer")int layer){
        if(returnBookService.resetBookPosition(bookId,room,sheet,layer)){
            return new UniversalResponseBody<>(0,"success");
        }else{
            return new UniversalResponseBody<>(-1,"error");
        }
    }
}
