package com.example.EngWorldBackend.Domain.AuthService;

import com.example.EngWorldBackend.Domain.Model.token.VerificationToken;
import com.example.EngWorldBackend.Domain.Request.AuthenticationRequest;
import com.example.EngWorldBackend.Domain.Respones.AuthenticationResponse;

import javax.servlet.http.HttpSession;

public interface AuthenService {
    AuthenticationResponse authenticate(AuthenticationRequest request, HttpSession session);

    String validateToken(String theToken);

    VerificationToken getToken(String token);
}
