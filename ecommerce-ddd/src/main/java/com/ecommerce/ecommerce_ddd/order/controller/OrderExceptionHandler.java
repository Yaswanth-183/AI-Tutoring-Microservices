package com.ecommerce.ecommerce_ddd.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIllegalStateException(
            IllegalStateException exception) {

        return new ErrorResponse(
                400,
                "Bad Request",
                exception.getMessage()
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIllegalArgumentException(
            IllegalArgumentException exception) {

        return new ErrorResponse(
                400,
                "Bad Request",
                exception.getMessage()
        );
    }

    public record ErrorResponse(
            int status,
            String error,
            String message
    ) {
    }
}