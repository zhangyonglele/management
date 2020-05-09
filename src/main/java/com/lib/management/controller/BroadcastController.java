package com.lib.management.controller;

import com.lib.management.dto.BroadcastTitleOnly;
import com.lib.management.dto.helper.NoticeHelper;
import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.model.BookManager;
import com.lib.management.model.LibrarianBroadcast;
import com.lib.management.service.BroadcastTitleOnlyService;
import com.lib.management.service.unit.NoticeService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class BroadcastController {
    @Resource
    private NoticeService noticeService;

    @GetMapping("/broadcast/page/{page}")
    public UniversalResponseBody getBroadcastByPage(@PathVariable("page")int page){
        return new UniversalResponseBody<>(0,"success",noticeService.getBroadcastListByPage(page));
    }

    @GetMapping("/broadcast/slideshow")
    public UniversalResponseBody getSlideShow(){
        return new UniversalResponseBody<>(0,"success",noticeService.getBroadcastForSlideshow());
    }

    @PostMapping("/broadcast")
    @LoginRequire("librarian")
    public UniversalResponseBody addNewBroadcast(NoticeHelper broadcast, HttpSession session){
        LibrarianBroadcast librarianBroadcast = broadcast.toBroadcast();
        BookManager manager = (BookManager)session.getAttribute("userInfo");
        librarianBroadcast.setCreateBy(manager.getBookManagerId());
        if(noticeService.addNotice(librarianBroadcast)){
            return new UniversalResponseBody(0,"success");
        }else{
            return new UniversalResponseBody(-1,"error");
        }
    }

    @GetMapping("/broadcast/id/{id}")
    public UniversalResponseBody getNoticeDetail(@PathVariable("id")int id){
        return new UniversalResponseBody(0,"success",noticeService.getNoticeDetailById(id));
    }

    @PutMapping("/broadcast")
    @LoginRequire("librarian")
    public UniversalResponseBody updateNoticeById(LibrarianBroadcast broadcast,HttpSession session){
        broadcast.setCreateTime(new Date());
        BookManager manager = (BookManager)session.getAttribute("userInfo");
        broadcast.setCreateBy(manager.getBookManagerId());
        if(noticeService.updateNotice(broadcast)){
            return new UniversalResponseBody(0,"success");
        }else{
            return new UniversalResponseBody(-1,"error");
        }
    }
}
