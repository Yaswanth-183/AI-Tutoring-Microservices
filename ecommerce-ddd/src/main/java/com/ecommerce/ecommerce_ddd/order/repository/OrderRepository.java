package com.ecommerce.ecommerce_ddd.order.repository;

import com.ecommerce.ecommerce_ddd.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}