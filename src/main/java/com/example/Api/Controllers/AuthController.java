package com.example.Api.Controllers;

import com.example.Application.Presentation.DTO.AuthResponse;
import com.example.Application.Presentation.DTO.LoginRequestDTO;
import com.example.Application.Presentation.DTO.SignInRequestDTO;
import org.springframework.http.ResponseEntity;

public interface AuthController {

    ResponseEntity<AuthResponse> registerUser(SignInRequestDTO signUpRequest);

    ResponseEntity<AuthResponse> authenticateUser(LoginRequestDTO loginRequest);
}
