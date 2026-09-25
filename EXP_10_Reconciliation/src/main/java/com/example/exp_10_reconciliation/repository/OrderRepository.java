package com.example.exp_10_reconciliation.repository;

import com.example.exp_10_reconciliation.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository
        extends JpaRepository<Order, Long> {

    List<Order> findByStatusAndUpdatedAtBefore(
            String status,
            LocalDateTime time
    );
}