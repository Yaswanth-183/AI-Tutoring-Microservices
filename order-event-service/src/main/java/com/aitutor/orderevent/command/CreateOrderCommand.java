package com.aitutor.orderevent.command;

import java.math.BigDecimal;

public record CreateOrderCommand(

        String correlationId,

        Long orderId,

        Long customerId,

        String productName,

        int quantity,

        BigDecimal amount

) {
}