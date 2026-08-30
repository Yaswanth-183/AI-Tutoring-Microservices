package com.aitutor.orderevent.event;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderCreatedEvent(

        String eventId,

        String correlationId,

        Long orderId,

        Long customerId,

        String productName,

        int quantity,

        BigDecimal amount,

        Instant timestamp

) {
}