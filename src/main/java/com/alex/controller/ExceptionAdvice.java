package com.alex.controller;

import com.alex.exceptions.ValidationAssignmentException;
import com.alex.exceptions.ValidationQuestException;
import com.alex.exceptions.ValidationUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionAdvice {

    private static final Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);

    //USER VALIDATION
    @ExceptionHandler({ValidationUserException.class})
    @ResponseStatus(BAD_REQUEST)
    ErrorResponse handleValidationUserException(ValidationUserException ex) {
        log.error("Received error {}", ex.getMessage());
        return ErrorResponse.builder(ex, BAD_REQUEST, ex.getMessage())
                .build();
    }
    //QUEST VALIDATION
    @ExceptionHandler({ValidationQuestException.class})
    @ResponseStatus(BAD_REQUEST)
    ErrorResponse handleValidationQuestException(ValidationQuestException ex) {
        log.error("Received error {}", ex.getMessage());
        return ErrorResponse.builder(ex, BAD_REQUEST, ex.getMessage())
                .build();
    }
    //ASSIGNMENT VALIDATION
    @ExceptionHandler({ValidationAssignmentException.class})
    @ResponseStatus(BAD_REQUEST)
    ErrorResponse handleValidationAssignmentException(ValidationAssignmentException ex) {
        log.error("Received error {}", ex.getMessage());
        return ErrorResponse.builder(ex, BAD_REQUEST, ex.getMessage())
                .build();
    }
}
