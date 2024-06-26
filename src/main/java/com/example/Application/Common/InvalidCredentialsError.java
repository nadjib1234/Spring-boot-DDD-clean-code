package com.example.Application.Common;

public class InvalidCredentialsError extends Error {

    public InvalidCredentialsError(String message) {
        super(message, 401); // 401 for Unauthorized
    }
}
