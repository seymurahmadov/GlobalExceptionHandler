package com.example.exceptionhandler.exception;

public class ProductNotNullException extends BadRequestException {

    public ProductNotNullException(String message){
        super(message);
    }
}
