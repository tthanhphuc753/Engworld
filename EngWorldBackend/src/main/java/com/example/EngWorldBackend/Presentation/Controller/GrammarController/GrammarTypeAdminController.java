package com.example.EngWorldBackend.Presentation.Controller.GrammarController;

import com.example.EngWorldBackend.DTO.Grammar.GrammarTypeDto;
import com.example.EngWorldBackend.DTO.Grammar.GrammarTypeResponse;
import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;
import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import com.example.EngWorldBackend.Domain.Respones.ResponseUtils;
import com.example.EngWorldBackend.Domain.Service.GrammarTypeService.GrammarTypeService;
import com.example.EngWorldBackend.Mapper.GrammarMapper;
import com.example.EngWorldBackend.Mapper.GrammarTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.EngWorldBackend.Domain.Respones.ResponseMessages.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/grammartype")
public class GrammarTypeAdminController {

    private final GrammarTypeService grammarTypeService;


    // GrammarType

    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addGrammar(@RequestBody GrammarTypeDto newGrammarType) {
        try {
            grammarTypeService.createGrammarType(GrammarTypeMapper.toEntity(newGrammarType));
            return ResponseUtils.buildCreatedResponse(newGrammarType, CREATED_SUCCESS_RESPONES);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllGrammarType(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){
        Page<GrammarType> grammarTypes = grammarTypeService.getAllGrammarTypes(pageNumber, pageSize);
        List<GrammarTypeDto> response = new ArrayList<>();

        for (GrammarType grammarType : grammarTypes) {
            GrammarTypeDto grammarTypeDto = GrammarTypeMapper.toDTO(grammarType);
            response.add(grammarTypeDto);
        }
        GrammarTypeResponse grammarTypeResponse = GrammarTypeMapper.mapToGrammarTypeResponse(response,grammarTypes);
        return ResponseUtils.buildSuccessResponse(grammarTypeResponse, SUCCESS_RESPONSE);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseObject> deleteGrammarTypeById(@RequestParam long grammarTypeId) {
        try {
            grammarTypeService.deleteGrammarType(grammarTypeId);
            return ResponseUtils.buildCreatedResponse(null, DELETE_SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, "Failed to delete data: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findGrammarTypeById(@PathVariable long id) {
        Optional<GrammarType> optionalGrammarType = grammarTypeService.getGrammarTypeById(id);
        if (optionalGrammarType.isPresent()) {
            GrammarType grammarType = optionalGrammarType.get();
            GrammarTypeDto grammarTypeDto = GrammarTypeMapper.toDTO(grammarType);
            return ResponseUtils.buildSuccessResponse(grammarTypeDto, SUCCESS_RESPONSE);
        } else {
            return ResponseUtils.buildErrorResponse(HttpStatus.NOT_FOUND, NOTFOUND_RESPONSE + id);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseObject> updateGrammarTypeById(@RequestParam long id, @RequestBody GrammarType newGrammarType) throws Exception {
        try {
            GrammarTypeDto grammarTypeUpdated = GrammarTypeMapper.toDTO(grammarTypeService.updateGrammarType(id, newGrammarType));
            return ResponseUtils.buildCreatedResponse(grammarTypeUpdated, SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }


}