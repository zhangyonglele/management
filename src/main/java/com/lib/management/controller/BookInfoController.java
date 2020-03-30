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
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class BookInfoController {
    @Resource
    private BookInfoService bookInfoService;

    @Resource
    private BookTypeService bookTypeService;

    @Resource
    private BookInfoResponseService bookInfoResponseService;

    @PostMapping("/book/info")
    @LoginRequire("librarian")
    public UniversalResponseBody addNewBookInfo(BookInfoHelper bookInfoHelper,HttpSession session){
        BookInfo bookInfo = bookInfoHelper.toBookInfo();
        //log.info("post func");
        BookManager bookManager = (BookManager)session.getAttribute("userInfo");
        bookInfo.setCreateBy(bookManager.getBookManagerId());
        bookInfo.setBookCopyNumber(0);
        bookInfo.setBookStatus(1);
        log.warn(""+bookInfo.getBookType()+"hello"+bookInfo.getBookAuthor());
        bookInfo.setBookTypeCode(bookTypeService
                .incrBookTypeCode(
                        bookInfo.getBookType()
                )
        );
        int insertId = bookInfoService.addNewBookInfo(bookInfo);
        if(insertId > 0){
            return new UniversalResponseBody(0,"success",insertId);
        }else {
            return new UniversalResponseBody(-1,"error");
        }

    }

    /**
     * 该方法被淘汰，对应getBookById
     * @param bookId
     * @return
     */
    //@GetMapping("/book/info/id/{id}")
    public UniversalResponseBody getBookInfoById(@PathVariable("id") int bookId){
        log.info("get func");
        return new UniversalResponseBody<>(
                0,
                "success",
                bookInfoResponseService.getBookInfoByBookInfoId(bookId)
        );
    }


    /**
     * 该方法被淘汰，对应于BookWithPicController中searchByBookName
     * @param bookName
     * @param page
     * @return
     */
    //@GetMapping("/books/info/name/{name}/page/{page}")
    public UniversalResponseBody getBookInfoByName(@PathVariable("name")String bookName,
                                                   @PathVariable("page")int page){
        return new UniversalResponseBody<>(
                0,
                "success",
                bookInfoResponseService.getBooksInfoByBookName(bookName,page)
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

    /**
     * 该功能被淘汰，对应BookWithPic中的searchBy方法
     * @param bookName
     * @param bookTypeMark
     * @param bookAuthor
     * @param bookPublisher
     * @param page
     * @return
     */
    //@GetMapping("/searchBy")
    public UniversalResponseBody searchBy(@RequestParam(value = "bookName",required = false)String bookName,
                                          @RequestParam(value = "bookTypeMark",required = false)String bookTypeMark,
                                          @RequestParam(value = "bookAuthor",required = false) String bookAuthor,
                                          @RequestParam(value = "bookPublisher",required = false)String bookPublisher,
                                          @RequestParam(value = "page") int page){
        Map<String,Object> multParams = new HashMap<>();
        if(bookName != null){
            multParams.put("bookName",bookName);
        }
        if(bookTypeMark != null){
            multParams.put("bookTypeMark",bookTypeMark);
        }
        if(bookAuthor != null){
            multParams.put("bookAuthor",bookAuthor);
        }
        if(bookPublisher != null){
            multParams.put("bookPublisher",bookPublisher);
        }
        multParams.put("pageNumber",(page-1) * 17);
        return new UniversalResponseBody<>(0,"success",bookInfoResponseService.searchByMultParams(multParams));
    }

}
