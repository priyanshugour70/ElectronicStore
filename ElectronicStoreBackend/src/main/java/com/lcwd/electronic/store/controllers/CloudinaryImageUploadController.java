package com.lcwd.electronic.store.controllers;

import com.lcwd.electronic.store.services.CloudinaryImageService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@SecurityRequirement(name="scheme1")
@RequestMapping("/cloudinary/upload")
public class CloudinaryImageUploadController {

    @Autowired
    private CloudinaryImageService cloudinaryImageService;

    @PostMapping("/{productId}")
    public ResponseEntity<Map> uploadImage(@RequestParam("image") MultipartFile file) {
        Map data = this.cloudinaryImageService.uplaod(file);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
