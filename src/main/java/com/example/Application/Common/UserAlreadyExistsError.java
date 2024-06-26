package com.example.Application.Common;

public class UserAlreadyExistsError extends Error {

    public UserAlreadyExistsError(String message) {
        super(message, 400); // 400 for Bad Request
    }
}
