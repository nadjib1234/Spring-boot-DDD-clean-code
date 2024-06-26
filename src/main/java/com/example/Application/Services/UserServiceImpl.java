package com.example.Application.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Application.Presentation.DTO.AuthResponse;
import com.example.Application.Presentation.DTO.LoginRequestDTO;
import com.example.Application.Presentation.DTO.SignInRequestDTO;
import com.example.Domain.Model.User;
import com.example.Domain.Repository.UserRepository;
import com.example.Infrastructure.Security.JwtUtil;
import com.example.Application.Common.Error;
import com.example.Application.Common.UserAlreadyExistsError;
import com.example.Application.Common.InvalidCredentialsError;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public AuthResponse registerUser(SignInRequestDTO signUpRequest) throws Error {
        // Check if user already exists
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new UserAlreadyExistsError("User with this email already exists");
        }

        // Create new user entity
        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setEmail(signUpRequest.getEmail());
        // Encrypt password before saving
        user.setPassword(bCryptPasswordEncoder.encode(signUpRequest.getPassword()));
        user.setDateOfBirth(new java.sql.Date(signUpRequest.getDateOfBirth().getTime()));

        // Save user in the database
        userRepository.save(user);

        // Generate JWT token
        String token = jwtUtil.generateToken(user.getFirstName(),user.getEmail(),user.getLastName());

        // Return authentication response
        return new AuthResponse(token, user.getFirstName(), user.getLastName(), user.getEmail());
    }

    @Override
    public AuthResponse authenticateUser(LoginRequestDTO loginRequest) throws Error {
        // Find user by email
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new InvalidCredentialsError("Invalid credentials"));

        // Validate password
        if (!bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsError("Invalid credentials");
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(user.getFirstName(),user.getEmail(),user.getLastName());

        // Return authentication response
        return new AuthResponse(token, user.getFirstName(), user.getLastName(), user.getEmail());
    }
}