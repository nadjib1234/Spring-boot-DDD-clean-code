package com.example.Api.Controllers;

import com.example.Application.Presentation.DTO.AuthResponse;
import com.example.Application.Presentation.DTO.LoginRequestDTO;
import com.example.Application.Presentation.DTO.SignInRequestDTO;
import com.example.Application.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class AuthControllerImpl {

    @Autowired
    private UserService userService;

    @PostMapping("/api/auth/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignInRequestDTO signUpRequest) throws Exception {
        AuthResponse authResponse = userService.registerUser(signUpRequest);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/api/auth/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) throws Exception {
        AuthResponse authResponse = userService.authenticateUser(loginRequest);
        return ResponseEntity.ok(authResponse);
    }
}
