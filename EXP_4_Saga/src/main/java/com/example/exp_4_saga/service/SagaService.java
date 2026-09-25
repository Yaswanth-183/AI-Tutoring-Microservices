package com.example.exp_4_saga.service;

import com.example.exp_4_saga.entity.Order;
import com.example.exp_4_saga.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class SagaService {

    private final OrderRepository orderRepository;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    public SagaService(
            OrderRepository orderRepository,
            InventoryService inventoryService,
            PaymentService paymentService) {

        this.orderRepository = orderRepository;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
    }

    public Order placeOrder(Order order) {

        // STEP 1: Create Order
        order.setStatus("CREATED");
        order = orderRepository.save(order);

        System.out.println("Order created: " + order.getId());

        // STEP 2: Payment
        boolean paid =
                paymentService.makePayment(order.getAmount());

        if (!paid) {
            order.setStatus("PAYMENT_FAILED");
            return orderRepository.save(order);
        }

        order.setStatus("PAID");
        order = orderRepository.save(order);

        // STEP 3: Inventory
        boolean reserved =
                inventoryService.reserveStock(
                        order.getProductId(),
                        order.getQuantity()
                );

        if (!reserved) {

            // COMPENSATION
            paymentService.refund(order.getAmount());

            order.setStatus("CANCELLED");

            return orderRepository.save(order);
        }

        // STEP 4: Confirm
        order.setStatus("CONFIRMED");

        return orderRepository.save(order);
    }
}