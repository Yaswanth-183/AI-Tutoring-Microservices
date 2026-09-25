package com.example.idempotency_demo.repository;

import com.example.idempotency_demo.entity.IdempotencyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdempotencyRecordRepository
        extends JpaRepository<IdempotencyRecord, String> {
}