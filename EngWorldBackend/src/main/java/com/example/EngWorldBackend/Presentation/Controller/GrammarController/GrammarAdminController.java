package com.example.EngWorldBackend.Presentation.Controller.GrammarController;

import com.example.EngWorldBackend.DTO.GrammarDto;
import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import com.example.EngWorldBackend.Domain.Respones.ResponseUtils;
import com.example.EngWorldBackend.Domain.Service.GrammarService.GrammarService;
import com.example.EngWorldBackend.Mapper.GrammarMapper;
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
@RequestMapping("/api/admin/grammar")
public class GrammarAdminController {

    private final GrammarService grammarService;
    private final GrammarMapper grammarMapper;

    // Grammar

    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addGrammar(@RequestBody GrammarDto newGrammar) {
        try {
            grammarService.createGrammar(grammarMapper.toEntity(newGrammar));
            return ResponseUtils.buildCreatedResponse(newGrammar, CREATED_SUCCESS_RESPONES);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllGrammar() {
        List<Grammar> grammars = grammarService.getAllGrammar();
        List<Object> response = new ArrayList<>();

        for (Grammar grammar : grammars) {
            GrammarDto grammarDto = GrammarMapper.toDTO(grammar);
            response.add(grammarDto);
        }
        return ResponseUtils.buildSuccessResponse(response, SUCCESS_RESPONSE);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseObject> deleteGrammarById(@RequestParam long id) {
        try {
            grammarService.deleteGrammarById(id);
            return ResponseUtils.buildCreatedResponse(null, DELETE_SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, "Failed to delete data: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findGrammarById(@PathVariable long id) {
        Optional<Grammar> optionalGrammar = grammarService.getGrammarById(id);
        if (optionalGrammar.isPresent()) {
            Grammar grammar = optionalGrammar.get();
            GrammarDto grammarDto = GrammarMapper.toDTO(grammar);
            return ResponseUtils.buildSuccessResponse(grammarDto, SUCCESS_RESPONSE);
        } else {
            return ResponseUtils.buildErrorResponse(HttpStatus.NOT_FOUND, NOTFOUND_RESPONSE + id);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseObject> updateGrammarById(@RequestParam long id, @RequestBody Grammar newGrammar) throws Exception {
        try {
            GrammarDto grammarUpdated = GrammarMapper.toDTO(grammarService.updateGrammarById(id, newGrammar));
            return ResponseUtils.buildCreatedResponse(grammarUpdated, SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }

    @GetMapping("/byType/{id}")
    public ResponseEntity<ResponseObject> getGrammarByType(@PathVariable long id) {
        List<Grammar> grammars = grammarService.getAllGrammarByType(id);
        List<GrammarDto> response = new ArrayList<>();
        for (Grammar grammar : grammars) {
            GrammarDto grammarDto = GrammarMapper.toDTO(grammar);
            response.add(grammarDto);
        }
        return ResponseUtils.buildSuccessResponse(response, SUCCESS_RESPONSE);
    }
}