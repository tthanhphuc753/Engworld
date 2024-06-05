package com.example.EngWorldBackend.Presentation.Controller.GrammarController;


import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/grammartype")
public class GrammarTypeClientController {

    private final GrammarTypeAdminController grammarTypeAdminController;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllGrammarType() {
        return grammarTypeAdminController.getAllGrammarType();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findGrammarTypeById(@PathVariable long id) {
        return grammarTypeAdminController.findGrammarTypeById(id);
    }
}
