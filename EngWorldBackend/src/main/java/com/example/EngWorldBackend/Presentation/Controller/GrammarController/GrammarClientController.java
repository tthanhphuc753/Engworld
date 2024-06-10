package com.example.EngWorldBackend.Presentation.Controller.GrammarController;


import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/grammar")
public class GrammarClientController {
    private final GrammarAdminController grammarAdminController;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllGrammar(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return grammarAdminController.getAllGrammar(pageNumber, pageSize);
    }

    @GetMapping("/byType/{id}")
    public ResponseEntity<ResponseObject> getGrammarByType(@PathVariable long id
            , @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber
            , @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return grammarAdminController.getGrammarByType(id, pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findGrammarById(@PathVariable long id) {
        return grammarAdminController.findGrammarById(id);
    }
}
