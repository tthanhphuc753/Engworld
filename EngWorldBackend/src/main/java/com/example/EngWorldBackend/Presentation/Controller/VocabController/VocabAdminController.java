package com.example.EngWorldBackend.Presentation.Controller.VocabController;


import com.example.EngWorldBackend.DTO.GrammarDto;
import com.example.EngWorldBackend.DTO.VocabularyDto;
import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import com.example.EngWorldBackend.Domain.Respones.ResponseUtils;
import com.example.EngWorldBackend.Domain.Service.VocabularyService.VocabularyService;
import com.example.EngWorldBackend.Mapper.GrammarMapper;
import com.example.EngWorldBackend.Mapper.VocabMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/vocab")
public class VocabAdminController {


    private final VocabularyService vocabService;


    private final String SUCCESS_RESPONES = "Successfully retrieve data";
    private final String DELETE_SUCCESS_RESPONES = "Deleted successfully";
    private final String NOTFOUND_RESPONES = "not found with id: ";
    private final String BAD_REQUEST = "error: ";


    //Vocabulary
    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllVocabulary() {
        List<Vocabulary> vocabs = vocabService.getAllVocab();
        List<Object> response = new ArrayList<>();

        for (Vocabulary vocab : vocabs) {
            VocabularyDto vocabularyDto = VocabMapper.toDTO(vocab);
            response.add(vocabularyDto);
        }
        return ResponseUtils.buildSuccessResponse(response, SUCCESS_RESPONES);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseObject> deleteVocabById(@RequestParam long vocabId) {

        try {
            vocabService.deleteVocabById(vocabId);
            return ResponseUtils.buildCreatedResponse(null, DELETE_SUCCESS_RESPONES);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, "Failed to delete data: " + e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findVocabById(@PathVariable long id) {
        Optional<Vocabulary> optionalVocab = vocabService.getVocabById(id);
        if (optionalVocab.isPresent()) {
            Vocabulary vocab = optionalVocab.get();
            VocabularyDto vocabularyDto = VocabMapper.toDTO(vocab);
            return ResponseUtils.buildSuccessResponse(vocabularyDto, SUCCESS_RESPONES);
        } else {
            return ResponseUtils.buildErrorResponse(HttpStatus.NOT_FOUND, NOTFOUND_RESPONES + id);
        }

    }


    @PostMapping("/update")
    public ResponseEntity<ResponseObject> updateVocabById(@RequestParam long id, @RequestBody Vocabulary newVocab) throws Exception {
        try {
            VocabularyDto vocabUpdated = VocabMapper.toDTO(vocabService.updateVocabById(id, newVocab));
            return ResponseUtils.buildCreatedResponse(vocabUpdated,SUCCESS_RESPONES);
        }catch (Exception e)
        {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST,BAD_REQUEST+e.getMessage());
        }
    }

    @GetMapping("/byTopic/{id}")
    public ResponseEntity<ResponseObject> getVocabByTopic(@PathVariable long id) {
        List<Vocabulary> vocabs = vocabService.getAllVocabByTopic(id);
        List<VocabularyDto> response = new ArrayList<>();
        for (Vocabulary vocab : vocabs) {
            VocabularyDto vocabDto = VocabMapper.toDTO(vocab);
            response.add(vocabDto);
        }
        return ResponseUtils.buildSuccessResponse(response, SUCCESS_RESPONES);
    }
}
