package com.example.EngWorldBackend.Presentation.Controller.QuestionController;

import com.example.EngWorldBackend.DTO.QuestionDto;
import com.example.EngWorldBackend.DTO.VocabularyDto;
import com.example.EngWorldBackend.Domain.Model.Question;
import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import com.example.EngWorldBackend.Domain.Respones.ResponseUtils;
import com.example.EngWorldBackend.Domain.Service.QuestionService.QuestionService;
import com.example.EngWorldBackend.Mapper.QuestionMapper;
import com.example.EngWorldBackend.Mapper.VocabMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.EngWorldBackend.Domain.Respones.ResponseMessages.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/question")
public class QuestionAdminController {

    private final QuestionService questionService;


    // Question

    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addQuestion(@RequestBody QuestionDto newQuestionDto) {
        try{
            questionService.createQuestion(QuestionMapper.toEntity(newQuestionDto));
            return ResponseUtils.buildCreatedResponse(newQuestionDto,CREATED_SUCCESS_RESPONES);
        }
        catch (Exception e){
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST,BAD_REQUEST+e.getMessage());
        }
    }
    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestion();
        List<Object> response = new ArrayList<>();

        for (Question question : questions) {
            QuestionDto questionDto = QuestionMapper.toDTO(question);
            response.add(questionDto);
        }
        return ResponseUtils.buildSuccessResponse(response, SUCCESS_RESPONSE);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseObject> deleteQuestionById(@RequestParam long questionId) {
        try {
            questionService.deleteQuestionById(questionId);
            return ResponseUtils.buildCreatedResponse(null, DELETE_SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, "Failed to delete data: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findQuestionById(@PathVariable long id) {
        Optional<Question> optionalQuestion = questionService.getQuestionById(id);
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            QuestionDto questionDto = QuestionMapper.toDTO(question);
            return ResponseUtils.buildSuccessResponse(questionDto, SUCCESS_RESPONSE);
        } else {
            return ResponseUtils.buildErrorResponse(HttpStatus.NOT_FOUND, NOTFOUND_RESPONSE + id);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseObject> updateQuestionById(@RequestParam long id, @RequestBody Question newQuestion) throws Exception {
        try {
            QuestionDto questionUpdated = QuestionMapper.toDTO(questionService.updateQuestionById(id, newQuestion));
            return ResponseUtils.buildCreatedResponse(questionUpdated, SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }

    @GetMapping("/byEx")
    public ResponseEntity<ResponseObject> getByEx(@RequestParam long exId)
    {
        List<Question> questions = questionService.getQuestionByEx(exId);
        List<Object> response = new ArrayList<>();

        for (Question question : questions) {
            QuestionDto questionDto = QuestionMapper.toDTO(question);
            response.add(questionDto);
        }
        return ResponseUtils.buildSuccessResponse(response, SUCCESS_RESPONSE);
    }
}
