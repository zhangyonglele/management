package com.lib.management.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import com.lib.management.model.Picture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;

@Component
@Slf4j
public class FileUtil {
    @Value("${OSS.endpoint}")
    private String endpoint;

    @Value("${OSS.accesskeyId}")
    private String accesskeyId;

    @Value("${OSS.bucketName}")
    private String bucketName;

    @Value("${OSS.accessKeySecret}")
    private String accessKeySecret;

    @Value("${OSS.bucketURL}")
    private String bucketURL;

    public String uploadFile2OSS(MultipartFile file){
        if (file.getSize() > 1024 * 1024 *20) {
            return "error";//RestResultGenerator.createErrorResult(ResponseEnum.PHOTO_TOO_MAX);
        }
        String originalFileName = file.getOriginalFilename();
        String fileType = "";
        if(originalFileName != null) {
            //Get file type to rebuild filename
            fileType = originalFileName.substring(originalFileName.lastIndexOf("."));
        }else{
            return "error";
        }
        //Rebuild file name
        Random randomHelper = new Random();
        String newFileName = randomHelper.nextInt(1000) + System.currentTimeMillis() + fileType;
        try{
            InputStream fileStream = file.getInputStream();
            String msg = uploadFile2OSS(fileStream,newFileName);
            if(msg.equals("success")) {
                return newFileName;
            }else if(msg.equals("error")){
                return "error";
            }
        }catch (IOException e){
            e.printStackTrace();
            return "error";
        }
        return "error";
    }

    private String uploadFile2OSS(InputStream fileStream,String fileName){
        String msg = "";
        OSS ossClient = new OSSClientBuilder().build(endpoint,accesskeyId,accessKeySecret);
        try{
            msg = "success";
            ossClient.putObject(bucketName,bucketURL+fileName,fileStream);
        }catch (Exception e){
            msg = "error";
            log.warn("[WARN CHECK] FILE UPLOADING ERROR!"+e.getMessage());
        }finally {
            ossClient.shutdown();
            try {
                fileStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return msg;
    }


}
