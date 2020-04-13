package com.cap.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.cap.exceptions.ErrorResponse;
import com.cap.exceptions.RecordNotFoundException;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Object> HandleException(Exception ex,WebRequest req){
	
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}