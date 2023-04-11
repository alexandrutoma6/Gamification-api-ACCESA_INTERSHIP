package com.alex.exceptions;

public class ValidationUserException extends RuntimeException{
    public ValidationUserException(String message){
        super(message);
    }
}
