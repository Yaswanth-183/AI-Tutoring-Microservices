package com.example.idempotent_demo.repository;

import com.example.idempotent_demo.entity.ProcessedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedEventRepository
        extends JpaRepository<ProcessedEvent, String> {

}