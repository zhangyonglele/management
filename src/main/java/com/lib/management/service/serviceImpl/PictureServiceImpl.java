package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.PictureMapper;
import com.lib.management.model.Picture;
import com.lib.management.service.PictureService;
import com.lib.management.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private FileUtil fileService;

    @Resource
    private PictureMapper pictureMapper;

    @Override
    public boolean uploadPicture(MultipartFile file, int bookId) {
        String fileUploadReturn = fileService.uploadFile2OSS(file);
        if(fileUploadReturn.equals("error")) {
            return false;
        }
        Picture picture = new Picture();
        picture.setPictureBookId(bookId);
        fileUploadReturn = "https://img-buck.oss-cn-beijing.aliyuncs.com/project/img/" + fileUploadReturn;
        picture.setPictureUrl(fileUploadReturn);
        boolean flag = false;
        try{
            pictureMapper.insert(picture);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public String uploadPicForBroadcast(MultipartFile file){
        String fileUploadReturn = fileService.uploadFile2OSS(file);
        if(fileUploadReturn.equals("error")) {
            return "error";
        }
        return "https://img-buck.oss-cn-beijing.aliyuncs.com/project/img/" + fileUploadReturn;
    }
}
