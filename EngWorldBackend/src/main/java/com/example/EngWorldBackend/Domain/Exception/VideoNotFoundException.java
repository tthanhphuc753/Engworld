package com.example.EngWorldBackend.Domain.Exception;

public class VideoNotFoundException extends RuntimeException{
    public VideoNotFoundException(String message) {
        super(message);
    }
}
