package com.example.EngWorldBackend.Presentation.Controller.VocabController;

import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/vocab")
public class VocabClientController {
    private final VocabAdminController vocabAdminController;

    @GetMapping("/byTopic/{id}")
    public ResponseEntity<ResponseObject> getVocabByTopic(@PathVariable long id) {

        return vocabAdminController.getVocabByTopic(id);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllVocabulary() {
        return vocabAdminController.getAllVocabulary();
    }
}
