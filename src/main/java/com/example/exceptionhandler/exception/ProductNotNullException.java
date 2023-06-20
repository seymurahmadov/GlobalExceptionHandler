package com.example.exceptionhandler.exception;

public class ProductNotNullException extends RuntimeException {

    public ProductNotNullException(String message){
        super(message);
    }
}
