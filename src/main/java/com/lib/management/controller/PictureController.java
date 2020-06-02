package com.lib.management.controller;

import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.service.PictureService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class PictureController {
    @Resource
    private PictureService pictureService;

    @PostMapping("/picture")
    @LoginRequire("librarian")
    public UniversalResponseBody<Object> uploadPicture(@RequestParam("file") MultipartFile file,int bookId){
        if(pictureService.uploadPicture(file,bookId)){
            return new UniversalResponseBody<>(0,"success");
        }else {
            return new UniversalResponseBody<>(-1,"error");
        }
    }

    @PostMapping("/broadcast/picture")
    @LoginRequire("librarian")
    public UniversalResponseBody getImageURL(@RequestParam("file") MultipartFile file){
        String ret = pictureService.uploadPicForBroadcast(file);
        if(ret.equals("error")){
            return new UniversalResponseBody(-1,"error");
        }else{
            return new UniversalResponseBody(0,"success",ret);
        }
    }
}
