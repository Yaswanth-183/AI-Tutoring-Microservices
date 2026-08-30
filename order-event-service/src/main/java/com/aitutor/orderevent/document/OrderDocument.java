package com.aitutor.orderevent.document;

import java.math.BigDecimal;

public record OrderDocument(

        Long orderId,

        Long customerId,

        String productName,

        int quantity,

        BigDecimal amount,

        String status

) {
}