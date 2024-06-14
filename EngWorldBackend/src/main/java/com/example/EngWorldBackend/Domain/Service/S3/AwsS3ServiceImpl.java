package com.example.EngWorldBackend.Domain.Service.S3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AwsS3ServiceImpl implements AwsS3Service {


    public static final String BUCKET_NAME = "ttp-engworld";

    private final AmazonS3Client awsS3Client;

    @Override
    public String uploadFile(MultipartFile file) {

        var filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        var key = UUID.randomUUID().toString() + filenameExtension;
        var metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        try {
            awsS3Client.putObject(BUCKET_NAME, key, file.getInputStream(), metadata);

        } catch (IOException ioException) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "an Exception occur while uploading file");
        }
        awsS3Client.setObjectAcl(BUCKET_NAME, key, CannedAccessControlList.PublicRead);

        return awsS3Client.getResourceUrl(BUCKET_NAME, key);
    }
    @Override
    public void deleteVideoFromS3(String videoPath) {

        awsS3Client.deleteObject(BUCKET_NAME, videoPath);

    }

    @Override
    public String extractKeyFromVideoPath(String videoPath) {
        String urlPrefix = "https://ttp-engworld.s3.ap-southeast-1.amazonaws.com/";

        if (videoPath.startsWith(urlPrefix)) {
            return videoPath.substring(urlPrefix.length());
        } else {
            throw new IllegalArgumentException("Invalid video path: " + videoPath);
        }
    }
}