package com.aitutor.cleanquestion.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.aitutor.cleanquestion.adapter.out.persistence.entity.QuestionEntity;
import com.aitutor.cleanquestion.application.port.out.QuestionRepositoryPort;
import com.aitutor.cleanquestion.domain.Question;

@Component
public class QuestionPersistenceAdapter
        implements QuestionRepositoryPort {

    private final QuestionJpaRepository repository;


    public QuestionPersistenceAdapter(
            QuestionJpaRepository repository) {

        this.repository = repository;
    }


    @Override
    public Question save(Question question) {

        QuestionEntity entity =
                toEntity(question);

        QuestionEntity saved =
                repository.save(entity);

        return toDomain(saved);
    }


    @Override
    public Optional<Question> findById(
            Long id) {

        return repository
                .findById(id)
                .map(this::toDomain);
    }


    @Override
    public List<Question> findAll() {

        return repository
                .findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }


    private QuestionEntity toEntity(
            Question question) {

        return new QuestionEntity(

                question.getQuestionText(),

                question.getTopic(),

                question.getDifficulty(),

                question.isActive()
        );
    }


    private Question toDomain(
            QuestionEntity entity) {

        return new Question(

                entity.getId(),

                entity.getQuestionText(),

                entity.getTopic(),

                entity.getDifficulty(),

                entity.isActive()
        );
    }
}