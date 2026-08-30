package com.aitutor.cleanquestion.application.port.in;

import java.util.List;

import com.aitutor.cleanquestion.domain.Question;

public interface QuestionUseCase {

    Question createQuestion(
            String questionText,
            String topic,
            String difficulty);

    Question getQuestion(Long id);

    List<Question> getAllQuestions();

    Question deactivateQuestion(Long id);
}