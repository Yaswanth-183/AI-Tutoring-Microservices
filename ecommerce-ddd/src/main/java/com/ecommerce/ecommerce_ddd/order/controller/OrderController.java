package com.ecommerce.ecommerce_ddd.order.controller;

import com.ecommerce.ecommerce_ddd.order.dto.CreateOrderRequest;
import com.ecommerce.ecommerce_ddd.order.entity.Order;
import com.ecommerce.ecommerce_ddd.order.service.OrderService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /*
     * Create Order
     */
    @PostMapping
    public Order createOrder(
            @RequestBody CreateOrderRequest request) {

        return orderService.createOrder(request);
    }

    /*
     * Get All Orders
     */
    @GetMapping
    public List<Order> getAllOrders() {

        return orderService.getAllOrders();
    }

    /*
     * Get Order by ID
     */
    @GetMapping("/{id}")
    public Order getOrder(
            @PathVariable Long id) {

        return orderService.getOrder(id);
    }

    /*
     * Confirm Order
     */
    @PutMapping("/{id}/confirm")
    public Order confirmOrder(
            @PathVariable Long id) {

        return orderService.confirmOrder(id);
    }

    /*
     * Cancel Order
     */
    @PutMapping("/{id}/cancel")
    public Order cancelOrder(
            @PathVariable Long id) {

        return orderService.cancelOrder(id);
    }
}