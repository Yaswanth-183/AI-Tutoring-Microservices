package com.example.business_invariant_demo.repository;

import com.example.business_invariant_demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}