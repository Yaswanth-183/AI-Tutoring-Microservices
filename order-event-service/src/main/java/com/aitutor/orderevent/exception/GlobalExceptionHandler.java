package com.aitutor.orderevent.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(
            IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>>
    handleIllegalArgument(
            IllegalArgumentException exception) {

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "timestamp",
                Instant.now());

        response.put(
                "status",
                400);

        response.put(
                "error",
                "Bad Request");

        response.put(
                "message",
                exception.getMessage());

        return ResponseEntity
                .badRequest()
                .body(response);
    }


    @ExceptionHandler(
            MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>>
    handleValidation(
            MethodArgumentNotValidException exception) {

        Map<String, String> errors =
                new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                    errors.put(
                            error.getField(),
                            error.getDefaultMessage()
                    )
                );


        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "timestamp",
                Instant.now());

        response.put(
                "status",
                400);

        response.put(
                "error",
                "Validation Failed");

        response.put(
                "errors",
                errors);


        return ResponseEntity
                .badRequest()
                .body(response);
    }
}