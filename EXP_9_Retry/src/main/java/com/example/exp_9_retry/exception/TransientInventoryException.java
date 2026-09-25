package com.example.exp_9_retry.exception;

public class TransientInventoryException
        extends RuntimeException {

    public TransientInventoryException(String message) {
        super(message);
    }
}