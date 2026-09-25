package com.example.exp_10_reconciliation.repository;

import com.example.exp_10_reconciliation.entity.InventoryReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryReservationRepository
        extends JpaRepository<
            InventoryReservation, Long> {

    Optional<InventoryReservation>
    findByOrderIdAndProductId(
            Long orderId,
            Long productId
    );
}