package com.example.exp_9_retry.repository;

import com.example.exp_9_retry.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository
        extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByRequestId(String requestId);
}