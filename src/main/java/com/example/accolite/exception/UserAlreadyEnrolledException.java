package com.example.accolite.exception;

public class UserAlreadyEnrolledException extends RuntimeException {
    public UserAlreadyEnrolledException(String message) {super(message);}
}