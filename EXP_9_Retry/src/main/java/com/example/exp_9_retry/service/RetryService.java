package com.example.exp_9_retry.service;

import com.example.exp_9_retry.entity.Reservation;
import com.example.exp_9_retry.exception.TransientInventoryException;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

    private final InventoryService inventoryService;

    private int simulatedFailures = 0;

    public RetryService(
            InventoryService inventoryService) {

        this.inventoryService = inventoryService;
    }

    public void configureFailures(int failures) {
        simulatedFailures = failures;
    }

    @Retryable(
        includes = TransientInventoryException.class,
        maxRetries = 3,
        delay = 1000,
        multiplier = 2,
        maxDelay = 5000
    )
    public Reservation reserveWithRetry(
            String requestId,
            Long productId,
            int quantity) {

        System.out.println(
                "Inventory attempt. Remaining simulated failures: "
                        + simulatedFailures
        );

        if (simulatedFailures > 0) {

            simulatedFailures--;

            throw new TransientInventoryException(
                    "Temporary inventory service failure"
            );
        }

        return inventoryService.reserve(
                requestId,
                productId,
                quantity
        );
    }
} 