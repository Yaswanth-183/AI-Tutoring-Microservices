package com.example.exp_10_reconciliation.service;

import com.example.exp_10_reconciliation.entity.InventoryReservation;
import com.example.exp_10_reconciliation.entity.Order;
import com.example.exp_10_reconciliation.repository.InventoryReservationRepository;
import com.example.exp_10_reconciliation.repository.OrderRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReconciliationService {

    private final OrderRepository orderRepository;
    private final InventoryReservationRepository
            reservationRepository;

    public ReconciliationService(
            OrderRepository orderRepository,
            InventoryReservationRepository reservationRepository) {

        this.orderRepository = orderRepository;
        this.reservationRepository =
                reservationRepository;
    }

    @Scheduled(
        fixedDelayString =
            "${reconciliation.fixed-delay}"
    )
    public void reconcileStaleOrders() {

        LocalDateTime cutoff =
                LocalDateTime.now().minusSeconds(30);

        List<Order> staleOrders =
                orderRepository
                        .findByStatusAndUpdatedAtBefore(
                                "PAID",
                                cutoff
                        );

        if (staleOrders.isEmpty()) {
            return;
        }

        System.out.println(
                "Reconciliation found "
                        + staleOrders.size()
                        + " stale order(s)"
        );

        for (Order order : staleOrders) {
            reconcile(order);
        }
    }

    @Transactional
    public void reconcile(Order order) {

        System.out.println(
                "Reconciling order "
                        + order.getId()
        );

        order.setReconciliationAttempts(
                order.getReconciliationAttempts() + 1
        );

        InventoryReservation reservation =
                reservationRepository
                        .findByOrderIdAndProductId(
                                order.getId(),
                                order.getProductId()
                        )
                        .orElse(null);

        if (reservation == null) {

            System.out.println(
                    "No inventory reservation found."
            );

            order.setStatus("CANCELLED");
            order.setUpdatedAt(
                    LocalDateTime.now()
            );

            orderRepository.save(order);

            System.out.println(
                    "Order "
                            + order.getId()
                            + " cancelled during reconciliation"
            );

            return;
        }

        if ("RESERVED".equals(
                reservation.getStatus())) {

            order.setStatus("CONFIRMED");
            order.setUpdatedAt(
                    LocalDateTime.now()
            );

            orderRepository.save(order);

            System.out.println(
                    "Order "
                            + order.getId()
                            + " reconciled to CONFIRMED"
            );
        }
    }
}