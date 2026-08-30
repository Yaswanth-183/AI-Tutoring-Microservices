package com.aitutor.cleanquestion.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aitutor.cleanquestion.adapter.out.persistence.entity.QuestionEntity;

public interface QuestionJpaRepository
        extends JpaRepository<QuestionEntity, Long> {
}