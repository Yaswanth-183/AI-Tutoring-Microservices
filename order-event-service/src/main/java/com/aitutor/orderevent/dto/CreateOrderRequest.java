package com.aitutor.orderevent.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;

public record CreateOrderRequest(

        @NotNull(message = "Customer ID is required")
        Long customerId,

        @NotBlank(message = "Product name is required")
        String productName,

        @Min(
            value = 1,
            message = "Quantity must be at least 1"
        )
        int quantity,

        @NotNull(message = "Amount is required")
        @DecimalMin(
            value = "0.01",
            message = "Amount must be greater than 0"
        )
        BigDecimal amount

) {
}