package com.aitutor.cleanquestion.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aitutor.cleanquestion.application.port.in.QuestionUseCase;
import com.aitutor.cleanquestion.application.port.out.QuestionRepositoryPort;
import com.aitutor.cleanquestion.domain.Question;
import com.aitutor.cleanquestion.exception.QuestionNotFoundException;

@Service
@Transactional
public class QuestionApplicationService
        implements QuestionUseCase {

    private final QuestionRepositoryPort repository;


    public QuestionApplicationService(
            QuestionRepositoryPort repository) {

        this.repository = repository;
    }


    @Override
    public Question createQuestion(
            String questionText,
            String topic,
            String difficulty) {

        Question question =
                Question.create(
                        questionText,
                        topic,
                        difficulty
                );

        return repository.save(question);
    }


    @Override
    @Transactional(readOnly = true)
    public Question getQuestion(Long id) {

        return repository.findById(id)
                .orElseThrow(
                    () -> new QuestionNotFoundException(id)
                );
    }


    @Override
    @Transactional(readOnly = true)
    public List<Question> getAllQuestions() {

        return repository.findAll();
    }


    @Override
    public Question deactivateQuestion(Long id) {

        Question question =
                getQuestion(id);

        question.deactivate();

        return repository.save(question);
    }
}