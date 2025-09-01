package com.mjc813.food_web.common.exception;

public class MyRequestException extends RuntimeException {
    public MyRequestException() {
        super();
    }

    public MyRequestException(String message) {
        super(message);
    }
}
