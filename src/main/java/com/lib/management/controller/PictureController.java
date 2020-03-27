package com.lib.management.controller;

import com.lib.management.service.PictureService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class PictureController {
    @Resource
    private PictureService pictureService;

    @PostMapping("/picture")
    public UniversalResponseBody<Object> uploadPicture(@RequestParam("file") MultipartFile file,int bookId){
        if(pictureService.uploadPicture(file,bookId)){
            return new UniversalResponseBody<>(0,"success");
        }else {
            return new UniversalResponseBody<>(-1,"error");
        }
    }


}
