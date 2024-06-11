package com.example.EngWorldBackend.Domain.Service.QuestionService;

import com.example.EngWorldBackend.Domain.Model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question createQuestion(Question newQuest);

    Optional<Question> getQuestionById(Long Id);

    Page<Question> getAllQuestion(int pageNumber, int pageSize);

    void deleteQuestionById(Long Id);

    Question updateQuestionById(Long Id, Question newQuestion);

    Page<Question> getAllQuestionGrammar(Long Id, int pageNumber, int pageSize);

    Page<Question> getQuestionByEx(long Id, int pageNumber, int pageSize);


    List<Question> addQuestionFromExcel(InputStream inputStream) throws IOException;
}
