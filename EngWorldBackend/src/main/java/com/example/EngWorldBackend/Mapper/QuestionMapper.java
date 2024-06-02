package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.QuestionDto;
import com.example.EngWorldBackend.Domain.Model.Question;

public class QuestionMapper {
    public static QuestionDto toDTO(Question question) {
        QuestionDto dto = new QuestionDto();
        dto.setQuestionId(question.getQuestionId());
        dto.setQuestionText(question.getQuestionText());
        dto.setCorrectAnswer(question.getCorrectAnswer());
        dto.setOp1(question.getOp1());
        dto.setOp2(question.getOp2());
        dto.setOp3(question.getOp3());
        return dto;
    }

    public static Question toEntity(QuestionDto dto) {
        Question question = new Question();
        question.setQuestionId(dto.getQuestionId());
        question.setQuestionText(dto.getQuestionText());
        question.setCorrectAnswer(dto.getCorrectAnswer());
        question.setOp1(dto.getOp1());
        question.setOp2(dto.getOp2());
        question.setOp3(dto.getOp3());
        return question;
    }
}
