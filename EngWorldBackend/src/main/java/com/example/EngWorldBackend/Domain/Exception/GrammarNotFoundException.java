package com.example.EngWorldBackend.Domain.Exception;

public class GrammarNotFoundException extends RuntimeException {
    public GrammarNotFoundException(String message) {
        super(message);
    }
}