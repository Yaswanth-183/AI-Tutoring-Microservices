package com.interview.interview_outbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InterviewOutboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewOutboxApplication.class, args);
    }
}