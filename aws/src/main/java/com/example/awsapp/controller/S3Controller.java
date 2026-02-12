package com.example.awsapp.controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.awsapp.services.S3Service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    @GetMapping("/")
    public ResponseEntity<String> readS3() {
        return ResponseEntity.status(HttpStatus.OK).body(s3Service.readS3());
    }
    

}
