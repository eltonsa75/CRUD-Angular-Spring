package com.elton.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.elton.exception.RecordNotFoundException;

@RestControllerAdvice
public  class ApplicationControllerAdvice {
    
    private static final HttpStatus HttpStatus = null;

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
    public String handleNotFoundException(RecordNotFoundException ex) {
        return ex.getMessage();
    }

}
