package com.example.exception;

public class DscException extends RuntimeException {
    private int errorCode;

    public DscException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
