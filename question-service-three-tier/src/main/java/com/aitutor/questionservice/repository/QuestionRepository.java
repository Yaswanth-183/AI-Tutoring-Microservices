package com.aitutor.questionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aitutor.questionservice.entity.Question;

public interface QuestionRepository
        extends JpaRepository<Question, Long> {

    List<Question> findByTopicIgnoreCase(String topic);

    List<Question> findByDifficultyIgnoreCase(
            String difficulty);

    List<Question> findByActiveTrue();
}