package com.example.idempotency_demo.repository;

import com.example.idempotency_demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}