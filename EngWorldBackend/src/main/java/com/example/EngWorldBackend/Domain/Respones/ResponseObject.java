package com.example.EngWorldBackend.Domain.Respones;

import lombok.Builder;

@Builder
public record ResponseObject(int status,
                             String message,
                             Object data) {
}
