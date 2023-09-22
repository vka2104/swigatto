package com.swigatto.swigatto.exception;

public class FoodNotAvailableException extends RuntimeException {
    public FoodNotAvailableException(String message) {
        super(message);
    }
}
