package com.example.EngWorldBackend.Domain.Service.QuestionService;

import com.example.EngWorldBackend.Domain.Model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question createQuestion(Question newQuest);

    Optional<Question> getQuestionById(Long Id);

    List<Question> getAllQuestion();

    void deleteQuestionById(Long Id);

    Question updateQuestionById(Long Id, Question newQuestion);

    List<Question> getAllQuestionGrammar(Long Id);

    List<Question> getQuestionByEx(long Id);
}
