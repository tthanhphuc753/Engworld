package com.example.EngWorldBackend.Domain.Service.QuestionService;

import com.example.EngWorldBackend.Domain.Exception.ExerciseNotFoundException;
import com.example.EngWorldBackend.Domain.Exception.GrammarNotFoundException;
import com.example.EngWorldBackend.Domain.Model.Exercise;
import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Model.Question;
import com.example.EngWorldBackend.Domain.Service.InputService.ExcelReader;
import com.example.EngWorldBackend.Persistence.DAO.ExerciseRepository;
import com.example.EngWorldBackend.Persistence.DAO.GrammarRepository;
import com.example.EngWorldBackend.Persistence.DAO.QuestionRepository;
import com.example.EngWorldBackend.Persistence.DAO.VocabularyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ExerciseRepository exerciseRepository;
    private final GrammarRepository grammarRepository;
    private final VocabularyRepository vocabularyRepository;
    private final ExcelReader excelReader;

    @Override
    public Question createQuestion(Question newQuest) {
        return questionRepository.save(newQuest);
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Page<Question> getAllQuestion(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return questionRepository.findAll(pageable);
    }

    @Override
    public void deleteQuestionById(Long id) {
        questionRepository.findById(id)
                .ifPresent(questionRepository::delete);
    }

    @Override
    public Question updateQuestionById(Long id, Question newQuestion) {
        return questionRepository.findById(id)
                .map(existingQuestion -> {
                    existingQuestion.setQuestionText(newQuestion.getQuestionText());
                    existingQuestion.setVocab(newQuestion.getVocab());
                    existingQuestion.setGrammar(newQuestion.getGrammar());
                    existingQuestion.setOp2(newQuestion.getOp2());
                    existingQuestion.setOp3(newQuestion.getOp3());
                    existingQuestion.setCorrectAnswer(newQuestion.getCorrectAnswer());
                    existingQuestion.setOp1(newQuestion.getOp1());
                    existingQuestion.setExercise(addQuestionToEx(newQuestion.getExercise()));
                    return questionRepository.save(existingQuestion);
                })
                .orElseThrow(() -> new IllegalStateException("Question with ID: " + id + " does not exist"));
    }

    private Exercise addQuestionToEx(Exercise exercise) {
        return exerciseRepository.findById(exercise.getExerciseId())
                .orElseThrow(() -> new ExerciseNotFoundException("Exercise not found with id: " + exercise.getExerciseId()));
    }

    @Override
    public Page<Question> getAllQuestionGrammar(Long grammarId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Grammar grammar = grammarRepository.findById(grammarId)
                .orElseThrow(() -> new GrammarNotFoundException("grammar not found with id: " + grammarId));
        return questionRepository.findByGrammar(grammar, pageable);
    }

    @Override
    public Page<Question> getQuestionByEx(long exerciseId, int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new ExerciseNotFoundException("Exercise not found with id: " + exerciseId));
        return questionRepository.findByExercise(exercise, pageable);
    }

    @Override
    public List<Question> addQuestionFromExcel(InputStream inputStream) throws IOException {
        List<Question> questions = excelReader.readQuestionFromExcel(inputStream, vocabularyRepository, grammarRepository, exerciseRepository);
        questionRepository.saveAll(questions);
        return questions;
    }
}