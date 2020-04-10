package com.lib.management.controller;

import com.lib.management.dto.helper.BookCopyHelper;
import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.model.BookManager;
import com.lib.management.model.Books;
import com.lib.management.service.BookService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class BookCopyController {
    @Resource
    private BookService bookService;

    @PostMapping("/librarian/bookcopy")
    @LoginRequire("librarian")
    public UniversalResponseBody<Object> addNewCopy(BookCopyHelper bookCopyHelper, int copyNumber,HttpSession session){
        BookManager bookManager = (BookManager)session.getAttribute("userInfo");
        Books book = bookCopyHelper.toBook();
        book.setBookCreateBy(bookManager.getBookManagerId());
        //book.setBookCreateBy(1);
        if(bookService.addNewBookCopy(book,copyNumber)){
            return new UniversalResponseBody<>(0,"success");
        }else{
            return new UniversalResponseBody<>(-1,"error");
        }
    }

    @GetMapping("/bookcopy/{bookInfoId}")
    public UniversalResponseBody getBookCopyByBookInfoId(@PathVariable("bookInfoId") int bookInfoId){
        return null;
    }

    @PutMapping("/librarian/bookcopy")
    @LoginRequire("librarian")
    public UniversalResponseBody<Object> updateBookCopyLocationInfo(){
        // TODO: 2020/3/25 这里需要实现只更新图书的位置信息
        return null;
    }

    @DeleteMapping("/librarian/bookcopy")
    @LoginRequire("librarian")
    public UniversalResponseBody<Object> removeACopy(@RequestParam("id") int BookId,HttpSession session){

        return null;
    }
}
