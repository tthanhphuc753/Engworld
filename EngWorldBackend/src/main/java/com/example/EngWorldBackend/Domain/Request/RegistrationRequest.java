package com.example.EngWorldBackend.Domain.Request;

public record RegistrationRequest(String firstName,
                                  String lastName,
                                  String email,
                                  String password) {

}
