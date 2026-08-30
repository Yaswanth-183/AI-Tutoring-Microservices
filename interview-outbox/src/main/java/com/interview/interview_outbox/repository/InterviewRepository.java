package com.interview.interview_outbox.repository;

import com.interview.interview_outbox.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository
        extends JpaRepository<Interview, Long> {
}