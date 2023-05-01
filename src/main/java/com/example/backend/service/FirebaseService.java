package com.example.backend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FirebaseService {
    String getSongUrl(String name);

//    FirebaseStorage
    String save(MultipartFile file) throws IOException;

    void delete(String name) throws IOException;

//    default String getExtension(String originalFileName) {
//        return StringUtil.getFilenameExtension(originalFileName);
//    }

//    default String generateFileName(String originalFileName) {
//        return UUID.randomUUID().toString() + getExtension(originalFileName);
//    }

    
}
