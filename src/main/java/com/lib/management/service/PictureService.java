package com.lib.management.service;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
    boolean uploadPicture(MultipartFile file,int bookId);
    String uploadPicForBroadcast(MultipartFile file);
}
