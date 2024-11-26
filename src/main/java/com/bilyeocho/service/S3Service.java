package com.bilyeocho.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final AmazonS3 amazonS3;

    @Value("${S3_BUCKET_NAME}")
    private String bucket;

    public String uploadFile(MultipartFile file) {
        String fileName = "images/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
        try {
            amazonS3.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), null));
        } catch (IOException e) {
            // 에러 메시지 및 스택 트레이스를 출력하고 런타임 예외를 던집니다.
            System.err.println("S3 파일 업로드 실패: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to upload file to S3", e);
        }
        return amazonS3.getUrl(bucket, fileName).toString();
    }

    public void deleteFile(String fileUrl) {
        try {
            String fileName = fileUrl.substring(fileUrl.indexOf("images/"));
            amazonS3.deleteObject(bucket, fileName);
            System.out.println("S3 파일 삭제 성공: " + fileName);
        } catch (Exception e) {
            // 에러 메시지 및 스택 트레이스를 출력하고 런타임 예외를 던집니다.
            System.err.println("S3 파일 삭제 실패: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to delete file from S3", e);
        }
    }
}