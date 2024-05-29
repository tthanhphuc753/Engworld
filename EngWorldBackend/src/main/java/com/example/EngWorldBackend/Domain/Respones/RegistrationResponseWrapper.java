package com.example.EngWorldBackend.Domain.Respones;

import lombok.Builder;

@Builder
public record RegistrationResponseWrapper(int status,
                                          String message,
                                          boolean success,
                                          RegistrationResponse user) {
}
