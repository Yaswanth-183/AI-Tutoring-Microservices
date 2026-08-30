package com.aitutor.orderevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aitutor.orderevent.entity.OrderEntity;

public interface OrderRepository
        extends JpaRepository<OrderEntity, Long> {
}