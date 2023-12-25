package com.example.accolite.exception;

public class UserAlreadyApprovedException extends RuntimeException{
    public UserAlreadyApprovedException(String msg) {
        super(msg);
    }
}
