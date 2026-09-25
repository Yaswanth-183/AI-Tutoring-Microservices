package com.example.exp_9_retry.controller;

import com.example.exp_9_retry.entity.Reservation;
import com.example.exp_9_retry.service.RetryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final RetryService retryService;

    public InventoryController(
            RetryService retryService) {

        this.retryService = retryService;
    }

    @PostMapping("/configure-failures/{count}")
    public String configureFailures(
            @PathVariable int count) {

        retryService.configureFailures(count);

        return "Configured " + count
                + " transient failures";
    }

    @PostMapping("/reserve")
    public ResponseEntity<?> reserve(
            @RequestParam String requestId,
            @RequestParam Long productId,
            @RequestParam int quantity) {

        try {

            Reservation reservation =
                    retryService.reserveWithRetry(
                            requestId,
                            productId,
                            quantity
                    );

            return ResponseEntity.ok(reservation);

        } catch (Exception e) {

            return ResponseEntity
                    .internalServerError()
                    .body(e.getMessage());
        }
    }
}