package com.lib.management.controller;

import com.lib.management.dto.BookWithPic;
import com.lib.management.service.BookWithPicService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class BookWithPicController {
    @Resource
    private BookWithPicService bookWithPicService;

    @GetMapping("/book/info/id/{id}")
    public UniversalResponseBody<BookWithPic> getBookById(@PathVariable("id") int bookInfoId){
        return new UniversalResponseBody<>(0,"success",bookWithPicService.getBookById(bookInfoId));
    }

    @GetMapping("/books/info/name/{name}/page/{page}")
    public UniversalResponseBody<List<BookWithPic>> searchBookByName(@PathVariable("name") String bookName,@PathVariable("page") int page){
        return new UniversalResponseBody<>(0,"success",bookWithPicService.searchByBookName(bookName,page));
    }

    @GetMapping("/searchBy")
    public UniversalResponseBody<List<BookWithPic>> searchBy(@RequestParam(value = "bookName",required = false)String bookName,
                                                       @RequestParam(value = "bookTypeMarks",required = false) List<String> bookTypeMark,
                                                       @RequestParam(value = "bookAuthor",required = false) String bookAuthor,
                                                       @RequestParam(value = "bookPublisher",required = false)String bookPublisher,
                                                       @RequestParam(value = "page") int page){
        Map<String,Object> params = new HashMap<>();
        params.put("bookName",bookName);
        params.put("bookTypeMarkList",bookTypeMark);
        params.put("bookAuthor",bookAuthor);
        params.put("bookPublisher",bookPublisher);
        params.put("pageNumber",(page-1)*16);
        return new UniversalResponseBody<>(0,"success",bookWithPicService.searchByMultiParams(params));
    }
}
