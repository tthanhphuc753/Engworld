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
    public ResponseEntity<ResponseObject> getAllQuestions() {
        return questionAdminController.getAllQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findQuestionById(@PathVariable long id) {
        return questionAdminController.findQuestionById(id);
    }

    @GetMapping("/byEx")
    public ResponseEntity<ResponseObject> getByEx(@RequestParam long exId) {
        return questionAdminController.getByEx(exId);
    }
}
