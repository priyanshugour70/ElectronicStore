package com.lcwd.electronic.store.services.impl;

import com.cloudinary.Cloudinary;
import com.lcwd.electronic.store.services.CloudinaryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryImageServiceImpl implements CloudinaryImageService {
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Map uplaod(MultipartFile file) {

        try {
            Map data = this.cloudinary.uploader().upload(file.getBytes(), Map.of());

//            public --> cloudinary image url, public id,  save...
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Image uploading fail !!");

        }


    }
}
