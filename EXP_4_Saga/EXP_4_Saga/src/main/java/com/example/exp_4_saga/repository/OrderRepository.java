package com.example.exp_4_saga.repository;

import com.example.exp_4_saga.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
        extends JpaRepository<Order, Long> {

}