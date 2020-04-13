package com.cap.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class RecordNotFoundException extends RuntimeException 
{
    public RecordNotFoundException(String exception) {
        super("name not found");
    }
 
}