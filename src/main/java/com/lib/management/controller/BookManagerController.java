package com.lib.management.controller;

import com.lib.management.dto.helper.BookManagerHelper;
import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.model.BookManager;
import com.lib.management.model.User;
import com.lib.management.service.BookManagerService;
import com.lib.management.service.UserService;
import com.lib.management.util.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class BookManagerController {
    @Resource
    private BookManagerService bookManagerService;

    @Resource
    private UserService userService;

    @PostMapping("/librarian/login")
    public UniversalResponseBody login(String userName, String password, HttpSession session){
        BookManager bookManager = bookManagerService.getBookManagerInfoByName(userName);
        if(bookManager != null  && bookManager.getActiveStatus() == 1 && bookManager.getBookManagerPassword().equals(password)){
            session.setAttribute("auth","librarian");
            session.setAttribute("userInfo",bookManager);
            return new UniversalResponseBody(0,"success");
        }else{
            log.warn("[WARRING CHECK] userName "+userName+",password " +password);
            return new UniversalResponseBody(-1,"auth refuse");
        }
    }

    @PostMapping("/librarian/logout")
    @LoginRequire("librarian")
    public UniversalResponseBody logout(HttpSession session){
        session.invalidate();
        return new UniversalResponseBody(0,"success");
    }

    @PutMapping("/librarian/find")
    public UniversalResponseBody findBackPasswordRequire(String userName){
        if(bookManagerService.changeManagerAccountStatus(userName,2)){
            return new UniversalResponseBody(0,"success");
        }else{
            return new UniversalResponseBody<>(-1,"error","该账户可能不存在");
        }
    }

    @GetMapping("/librarian/init/reader/{page}")
    @LoginRequire("librarian")
    public UniversalResponseBody<List<User>> getUninitReadersAccount(@PathVariable int page){
        return new UniversalResponseBody<>(0,"success",userService.getUninitReaderAccount(page));
    }

    @PutMapping("/librarian/init")
    @LoginRequire("librarian")
    public UniversalResponseBody initReaderAccount(int readerId,HttpSession session){
        BookManager bookManager = (BookManager)session.getAttribute("userInfo");
        if(userService.initReaderAccountByReaderId(readerId,bookManager.getBookManagerId())) {
            return new UniversalResponseBody(0,"success");
        }else{
            return new UniversalResponseBody(-1,"error");
        }
    }

    @DeleteMapping("/librarian/reader/{ID}")
    @LoginRequire("librarian")
    public UniversalResponseBody<Object> deleteReaderAccount(@PathVariable("ID")int readerId){
        if(userService.deleteUserInfo(readerId)){
            return new UniversalResponseBody<>(0,"success");
        }else{
            return new UniversalResponseBody<>(-1,"error");
        }
    }

    @GetMapping("/librarian/reader/id/{id}")
    @LoginRequire("librarian")
    public UniversalResponseBody<User> findReaderByUserId(@PathVariable("id")int id){
        return new UniversalResponseBody<>(0,"success",userService.getUserInfoByUserId(id));
    }

    @GetMapping("/librarian/reader/name/{name}")
    @LoginRequire("librarian")
    public UniversalResponseBody<User> findReaderByUserName(@PathVariable("name")String userName){
        return new UniversalResponseBody<>(0,"success",userService.getUserInfoByName(userName));
    }



    @PostMapping("/librarian/register")
    public UniversalResponseBody<Object> register(BookManagerHelper bookManagerHelper){
        if(bookManagerService.registerForNewManager(bookManagerHelper)){
            return new UniversalResponseBody<>(0,"success");
        }else{
            return new UniversalResponseBody<>(-1,"error");
        }
    }

    @PutMapping("/librarian/recover")
    public UniversalResponseBody recoverLibrarianPassword(@RequestParam("userAccount")String userName){
        if(bookManagerService.recoverLibrarianAccount(userName)){
            return new UniversalResponseBody(0,"success");
        }else{
            return new UniversalResponseBody(-1,"error");
        }
    }
}
