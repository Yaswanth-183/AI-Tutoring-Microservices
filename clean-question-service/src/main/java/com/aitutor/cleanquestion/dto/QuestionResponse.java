package com.aitutor.cleanquestion.dto;

import com.aitutor.cleanquestion.domain.Question;

public record QuestionResponse(

        Long id,

        String questionText,

        String topic,

        String difficulty,

        boolean active

) {

    public static QuestionResponse
    from(Question question) {

        return new QuestionResponse(

                question.getId(),

                question.getQuestionText(),

                question.getTopic(),

                question.getDifficulty(),

                question.isActive()
        );
    }
}