package com.example.awsapp.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3Client s3Client;


    public String readS3(){
        GetObjectRequest request=GetObjectRequest.builder()
        .bucket("your-temp-ml-bucket")
        .key("test.txt")
        .build();

        ResponseBytes<GetObjectResponse> objecBytes=s3Client.getObjectAsBytes(request);
        return objecBytes.asUtf8String();

    } 

}
