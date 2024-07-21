package com.example.EngWorldBackend.Presentation.Controller.QuestionController;


import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/question")
public class QuestionClientController {
    private final QuestionAdminController questionAdminController;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllQuestions(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return questionAdminController.getAllQuestions(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findQuestionById(@PathVariable long id) {
        return questionAdminController.findQuestionById(id);
    }

    @GetMapping("/byEx")
    public ResponseEntity<ResponseObject> getByEx(@RequestParam long exId
            , @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber
            , @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return questionAdminController.getByEx(exId, pageNumber, pageSize);
    }
}
