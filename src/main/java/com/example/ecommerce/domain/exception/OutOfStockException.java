package com.example.ecommerce.domain.exception;

public class OutOfStockException extends RuntimeException{
    public OutOfStockException() {
        super("Not enough inventory available");
    }
}
