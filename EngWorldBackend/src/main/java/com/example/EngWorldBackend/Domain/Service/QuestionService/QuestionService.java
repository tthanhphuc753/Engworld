package com.example.EngWorldBackend.Domain.Service.QuestionService;

import com.example.EngWorldBackend.Domain.Model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question createQuestion(Question newQuest);

    Optional<Question> getQuestionById(Long id);

    List<Question> getAllQuestion();

    void deleteQuestionById(Long id);

    Question updateQuestionById(Long id, Question newQuestion);

    List<Question> getAllQuestionByTopic(Long topicId);
}
