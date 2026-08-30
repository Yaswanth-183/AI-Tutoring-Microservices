package com.ecommerce.ecommerce_ddd.order.service;

import com.ecommerce.ecommerce_ddd.order.dto.CreateOrderRequest;
import com.ecommerce.ecommerce_ddd.order.entity.Order;
import com.ecommerce.ecommerce_ddd.order.entity.OrderItem;
import com.ecommerce.ecommerce_ddd.order.repository.OrderRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /*
     * Create Order
     */
    @Transactional
    public Order createOrder(CreateOrderRequest request) {

        if (request == null) {
            throw new IllegalArgumentException(
                    "Order request cannot be null"
            );
        }

        if (request.customerId() == null) {
            throw new IllegalArgumentException(
                    "Customer ID is required"
            );
        }

        if (request.items() == null || request.items().isEmpty()) {
            throw new IllegalArgumentException(
                    "Order must contain at least one item"
            );
        }

        /*
         * Create Aggregate Root
         */
        Order order = new Order(
                request.customerId()
        );

        /*
         * Add items through Aggregate Root
         */
        for (CreateOrderRequest.OrderItemRequest itemRequest
                : request.items()) {

            if (itemRequest.productId() == null) {
                throw new IllegalArgumentException(
                        "Product ID is required"
                );
            }

            if (itemRequest.price() < 0) {
                throw new IllegalArgumentException(
                        "Price cannot be negative"
                );
            }

            OrderItem item = new OrderItem(
                    itemRequest.productId(),
                    itemRequest.productName(),
                    BigDecimal.valueOf(itemRequest.price()),
                    itemRequest.quantity()
            );

            order.addItem(item);
        }

        /*
         * Save entire aggregate
         */
        return orderRepository.save(order);
    }

    /*
     * Get Order
     */
    public Order getOrder(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Order not found with id: " + id
                        )
                );
    }

    /*
     * Get all Orders
     */
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    /*
     * Confirm Order
     */
    @Transactional
    public Order confirmOrder(Long id) {

        Order order = getOrder(id);

        /*
         * Business logic belongs to Aggregate
         */
        order.confirm();

        return orderRepository.save(order);
    }

    /*
     * Cancel Order
     */
    @Transactional
    public Order cancelOrder(Long id) {

        Order order = getOrder(id);

        /*
         * Business logic belongs to Aggregate
         */
        order.cancel();

        return orderRepository.save(order);
    }
}