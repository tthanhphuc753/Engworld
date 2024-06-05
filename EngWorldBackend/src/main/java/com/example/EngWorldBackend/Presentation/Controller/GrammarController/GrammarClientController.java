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
@RequestMapping("/api/client/grammar")
public class GrammarClientController {
    private final GrammarAdminController grammarAdminController;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllGrammar() {
        return grammarAdminController.getAllGrammar();
    }

    @GetMapping("/byType/{id}")
    public ResponseEntity<ResponseObject> getGrammarByType(@PathVariable long id) {
        return grammarAdminController.getGrammarByType(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findGrammarById(@PathVariable long id){
        return grammarAdminController.findGrammarById(id);
    }
}
