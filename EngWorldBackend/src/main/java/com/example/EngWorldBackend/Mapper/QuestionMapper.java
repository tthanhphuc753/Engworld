package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.Question.QuestionDto;
import com.example.EngWorldBackend.DTO.Question.QuestionResponse;
import com.example.EngWorldBackend.Domain.Model.Exercise;
import com.example.EngWorldBackend.Domain.Model.Question;
import com.example.EngWorldBackend.Persistence.DAO.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionMapper {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public QuestionDto toDTO(Question question) {
        QuestionDto dto = new QuestionDto();
        dto.setQuestionId(question.getQuestionId());
        dto.setQuestionText(question.getQuestionText());
        dto.setCorrectAnswer(question.getCorrectAnswer());
        dto.setOp1(question.getOp1());
        dto.setOp2(question.getOp2());
        dto.setOp3(question.getOp3());
        Exercise exercise = exerciseRepository.findById(question.getExercise().getExerciseId()).get();
        dto.setExerciseType(exercise.getExerciseTitle());
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

    public static QuestionResponse mapToQuestionResponse(List<QuestionDto> questionDtos, Page<Question> questions) {
        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setContent(questionDtos);
        questionResponse.setPageNumber(questions.getNumber());
        questionResponse.setPageSize(questions.getSize());
        questionResponse.setTotalElements(questions.getTotalElements());
        questionResponse.setTotalPages(questions.getTotalPages());
        questionResponse.setLast(questions.isLast());

        return questionResponse;
    }
}
