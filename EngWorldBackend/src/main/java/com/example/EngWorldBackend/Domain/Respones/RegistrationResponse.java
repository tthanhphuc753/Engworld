package com.example.EngWorldBackend.Domain.Respones;

import lombok.Builder;

@Builder
public record RegistrationResponse(String firstName,
                                   String lastName,
                                   String email
) {
}
