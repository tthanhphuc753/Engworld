package com.example.EngWorldBackend.Presentation.Controller.VocabController;

import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/vocab")
public class VocabClientController {
    private final VocabAdminController vocabAdminController;

    @GetMapping("/byTopic/{id}")
    public ResponseEntity<ResponseObject> getVocabByTopic(@PathVariable long id
            , @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber
            , @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {

        return vocabAdminController.getVocabByTopic(id, pageNumber, pageSize);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllVocabulary(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return vocabAdminController.getAllVocabulary(pageNumber, pageSize);
    }
}
