package com.example.exceptionhandler.exception;

public class ProductNotFoundException extends NotFoundException {

    public ProductNotFoundException(String message) {
        super(message);
    }

}
