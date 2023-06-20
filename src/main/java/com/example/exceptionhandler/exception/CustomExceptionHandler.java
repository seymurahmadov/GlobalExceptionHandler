package com.example.exceptionhandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFoundException(ProductNotFoundException productNotFoundException){

        List<String> detail = new ArrayList<>();
        detail.add(productNotFoundException.getMessage());
        ErrorResponse errorResponse= new ErrorResponse("Product not found", detail);
        return new  ResponseEntity<> (errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ProductNotNullException.class)
    public ResponseEntity<?> productNotNullException(ProductNotNullException productNotNullException){

        List<String> detail = new ArrayList<>();
        detail.add(productNotNullException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Product not null", detail);
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }
}
