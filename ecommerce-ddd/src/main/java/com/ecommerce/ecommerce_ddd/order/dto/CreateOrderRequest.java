package com.ecommerce.ecommerce_ddd.order.dto;

import java.util.List;

public record CreateOrderRequest(
        Long customerId,
        List<OrderItemRequest> items
) {

    public record OrderItemRequest(
            Long productId,
            String productName,
            double price,
            int quantity
    ) {
    }
}