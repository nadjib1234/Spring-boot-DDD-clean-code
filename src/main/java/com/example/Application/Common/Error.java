package com.example.Application.Common;

public abstract class Error extends Exception{

    private final String message;
    private final int status;

    public Error(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}