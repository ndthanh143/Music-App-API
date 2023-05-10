//package com.example.backend.service.impl;
//
//import com.example.backend.service.FirebaseService;
//import com.google.cloud.firestore.Firestore;
//import com.google.firebase.cloud.FirestoreClient;
//import com.google.firebase.cloud.StorageClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//@Service
//public class FirebaseServiceImpl implements FirebaseService {
//    Properties properties;
//
////    @EventListener
////    public void init(ApplicationReadyEvent event) {
////        try {
////            ClassPathResource serviceAccount = new ClassPathResource("firebase.json");
////
////            FirebaseOptions options = new FirebaseOptions.Builder()
////                    .setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream()))
////                    .setStorageBucket(properties.getB)
////        }
////    }
//
//    @Override
//    public String getSongUrl(String name) {
//        properties = new Properties();
//        System.out.println("propertis" + properties.getProperty("firebase.song-url"));
//        return  null;
//    }
//
//    @Override
//    public String save(MultipartFile file) throws IOException {
//        // Lấy reference đến Firebase Storage
////        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
////
////        // Tạo child reference trong Firebase Storage
////        StorageReference fileReference = storageReference.child("images/" + fileName);
////
////        // Upload file lên Firebase Storage
////        FileInputStream stream = new FileInputStream(file);
////        fileReference.putStream(stream)
////                .addOnSuccessListener(taskSnapshot -> {
////                    System.out.println("File uploaded successfully!");
////                })
////                .addOnFailureListener(exception -> {
////                    System.out.println("File upload failed!");
////                });
//        return null;
//    }
//
//    @Override
//    public void delete(String name) throws IOException {
//
//    }
//}
