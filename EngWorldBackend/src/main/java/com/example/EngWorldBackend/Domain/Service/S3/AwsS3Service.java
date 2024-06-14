package com.example.EngWorldBackend.Domain.Service.S3;

import org.springframework.web.multipart.MultipartFile;

public interface AwsS3Service {
    String uploadFile(MultipartFile file);

    void deleteVideoFromS3(String videoPath);

    String extractKeyFromVideoPath(String videoPath);
}
