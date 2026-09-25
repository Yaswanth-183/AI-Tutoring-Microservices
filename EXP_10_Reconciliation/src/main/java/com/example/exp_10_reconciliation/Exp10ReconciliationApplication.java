package com.example.exp_10_reconciliation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Exp10ReconciliationApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                Exp10ReconciliationApplication.class,
                args
        );
    }
}