package com.example.EngWorldBackend.Presentation.Controller.GrammarController;


import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/grammartype")
public class GrammarTypeClientController {

    private final GrammarTypeAdminController grammarTypeAdminController;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllGrammarType(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return grammarTypeAdminController.getAllGrammarType(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findGrammarTypeById(@PathVariable long id) {
        return grammarTypeAdminController.findGrammarTypeById(id);
    }
}
