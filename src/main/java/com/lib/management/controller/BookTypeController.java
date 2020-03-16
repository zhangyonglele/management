package com.lib.management.controller;

import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.model.BookManager;
import com.lib.management.model.BookType;
import com.lib.management.service.BookTypeService;
import com.lib.management.util.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;


@RestController
@Slf4j
public class BookTypeController {
    @Resource
    private BookTypeService bookTypeService;

    @PostMapping("/librarian/bookType/add")
    //@LoginRequire("librarian")
    public UniversalResponseBody addNewBookType(@RequestParam("bookTypeMark") String bookTypeMark,
                                                @RequestParam("bookTypeName") String bookTypeName,
                                                HttpSession session){
        BookType newBookType = new BookType();
        BookManager bookManager = (BookManager)session.getAttribute("userInfo");
        if(bookManager == null){
            log.error("登录信息异常");
            return new UniversalResponseBody<>(-1,"error");
        }
        newBookType.setBookTypeMark(bookTypeMark);
        newBookType.setBookTypeName(bookTypeName);
        newBookType.setCreateBy(bookManager.getBookManagerId());
        newBookType.setCreateTime(new Date());
        newBookType.setLargestCode(0);
        if(bookTypeService.addANewType(newBookType)){
            return new UniversalResponseBody(0,"success");
        }else{
            return new UniversalResponseBody(-1,"error");
        }
    }

    @GetMapping("/bookTypes")
    public UniversalResponseBody getAllBookType(){
        return new UniversalResponseBody<>(0,"success",bookTypeService.getAllType());
    }


}
