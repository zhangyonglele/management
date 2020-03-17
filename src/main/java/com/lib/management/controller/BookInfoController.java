package com.lib.management.controller;

import com.lib.management.dto.BookInfoHelper;
import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.model.BookInfo;
import com.lib.management.model.BookManager;
import com.lib.management.service.BookInfoResponseService;
import com.lib.management.service.BookInfoService;
import com.lib.management.service.BookTypeService;
import com.lib.management.util.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class BookInfoController {
    @Resource
    private BookInfoService bookInfoService;

    @Resource
    private BookTypeService bookTypeService;

    @Resource
    private BookInfoResponseService bookInfoResponseService;

    @PostMapping("/book/info")
    @LoginRequire("librarian")
    public UniversalResponseBody addNewBookInfo(BookInfoHelper bookInfoHelper, HttpSession session){
        BookInfo bookInfo = bookInfoHelper.toBookInfo();
        //log.info("post func");
        BookManager bookManager = (BookManager)session.getAttribute("userInfo");
        bookInfo.setCreateBy(bookManager.getBookManagerId());
        bookInfo.setBookCopyNumber(0);
        bookInfo.setBookStatus(1);
        bookInfo.setBookTypeCode(bookTypeService
                .incrBookTypeCode(
                        bookInfo.getBookType()
                )
        );
        if(bookInfoService.addNewBookInfo(bookInfo)){
            return new UniversalResponseBody(0,"success");
        }else {
            return new UniversalResponseBody(-1,"error");
        }

    }

    @GetMapping("/book/info/id/{id}")
    public UniversalResponseBody getBookInfoById(@PathVariable("id") int bookId){
        log.info("get func");
        return new UniversalResponseBody<>(
                0,
                "success",
                bookInfoResponseService.getBookInfoByBookInfoId(bookId)
        );
    }

    @GetMapping("/books/info/name/{name}")
    public UniversalResponseBody getBookInfoByName(@PathVariable("name")String bookName){
        return new UniversalResponseBody<>(
                0,
                "success",
                bookInfoResponseService.getBooksInfoByBookName(bookName)
        );
    }

    @PutMapping("/book/info/{bookInfoId}")
    @LoginRequire("librarian")
    public UniversalResponseBody updateBookInfoById(@PathVariable("bookInfoId")int bookInfoId,
                                                    BookInfoHelper bookInfoHelper){
        BookInfo bookInfo = bookInfoHelper.toBookInfo();
        bookInfo.setBookInfoId(bookInfoId);
        if(bookInfoService.updateBookInfo(bookInfo)){
            return new UniversalResponseBody(0,"success");
        }else {
            return new UniversalResponseBody(0, "error");
        }
    }

    @DeleteMapping("/book/info/{id}")
    @LoginRequire("librarian")
    public UniversalResponseBody removeBookInfoById(@PathVariable("id") int bookId){

        if(bookInfoService.updateABookInfoStatus(bookId,0)){
            return new UniversalResponseBody(0,"success");
        }else{
            return new UniversalResponseBody(-1,"error");
        }
    }
}
