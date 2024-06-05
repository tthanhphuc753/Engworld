package com.example.EngWorldBackend.Domain.Service.QuestionService;

import com.example.EngWorldBackend.Domain.Model.Exercise;
import com.example.EngWorldBackend.Domain.Model.Question;
import com.example.EngWorldBackend.Persistence.DAO.ExerciseRepository;
import com.example.EngWorldBackend.Persistence.DAO.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {


    private final QuestionRepository questionRepository;
    private final ExerciseRepository exerciseRepository;

    @Override
    public Question createQuestion(Question newQuest) {
        return questionRepository.save(newQuest);
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public void deleteQuestionById(Long id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Question with ID: " + id + " does not exist");
        }
    }

    @Override
    public Question updateQuestionById(Long id, Question newQuestion) {
        return questionRepository.findById(id)
                .map(existingQuestion -> {
                    existingQuestion.setQuestionText(newQuestion.getQuestionText());
                    existingQuestion.setVocab(newQuestion.getVocab());
                    existingQuestion.setGrammarId(newQuestion.getGrammarId());
                    existingQuestion.setOp2(newQuestion.getOp2());
                    existingQuestion.setOp3(newQuestion.getOp3());
                    existingQuestion.setCorrectAnswer(newQuestion.getCorrectAnswer());
                    existingQuestion.setOp1(newQuestion.getOp1());
                    existingQuestion.setExerciseId(addQuestionToEx(newQuestion.getExerciseId()));
                    return questionRepository.save(existingQuestion);
                })
                .orElseThrow(() -> new IllegalStateException("Question with ID: " + id + " does not exist"));
    }

    private Exercise addQuestionToEx(Exercise exercise) {
        return exerciseRepository.findById(exercise.getExerciseId())
                .orElseThrow(() -> new ExerciseNotFoundException("GrammarType not found with id: " + exercise.getExerciseId()));
    }

    @Override
    public List<Question> getAllQuestionGrammar(Long topicId) {
        return questionRepository.findAllByGrammarId(topicId);
    }

    @Override
    public List<Question> getQuestionByEx(long id) {
        return questionRepository.findAllByExerciseId(id);
    }

    private static class ExerciseNotFoundException extends RuntimeException {
        public ExerciseNotFoundException(String message) {
            super(message);
        }
    }
}
