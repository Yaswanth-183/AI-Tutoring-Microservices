package com.example.payment_compensation_demo.repository;

import com.example.payment_compensation_demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}