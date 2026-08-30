package com.aitutor.cleanquestion.application.port.out;

import java.util.List;
import java.util.Optional;

import com.aitutor.cleanquestion.domain.Question;

public interface QuestionRepositoryPort {

    Question save(Question question);

    Optional<Question> findById(Long id);

    List<Question> findAll();
}