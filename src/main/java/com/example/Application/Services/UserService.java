package com.example.Application.Services;

import com.example.Application.Presentation.DTO.AuthResponse;
import com.example.Application.Presentation.DTO.LoginRequestDTO;
import com.example.Application.Presentation.DTO.SignInRequestDTO;

public interface UserService {
    
    AuthResponse registerUser(SignInRequestDTO signUpRequest) throws  com.example.Application.Common.Error;

    AuthResponse authenticateUser(LoginRequestDTO loginRequest) throws com.example.Application.Common.Error;
}

