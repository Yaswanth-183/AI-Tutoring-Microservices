package com.aitutor.orderevent.query;

public record GetInventoryAvailability(

        String correlationId,

        Long productId,

        int requestedQuantity

) {
}