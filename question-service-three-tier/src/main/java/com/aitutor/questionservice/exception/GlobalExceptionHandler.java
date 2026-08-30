package com.aitutor.questionservice.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(QuestionNotFoundException.class)
    public ResponseEntity<Map<String, Object>>
    handleQuestionNotFound(
            QuestionNotFoundException exception) {

        Map<String, Object> response =
                new HashMap<>();

        response.put("timestamp", Instant.now());
        response.put("status", 404);
        response.put("error", "Question Not Found");
        response.put("message",
                exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }


    @ExceptionHandler(
            MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>>
    handleValidation(
            MethodArgumentNotValidException exception) {

        Map<String, Object> errors =
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

        response.put("timestamp", Instant.now());
        response.put("status", 400);
        response.put("errors", errors);

        return ResponseEntity
                .badRequest()
                .body(response);
    }
}