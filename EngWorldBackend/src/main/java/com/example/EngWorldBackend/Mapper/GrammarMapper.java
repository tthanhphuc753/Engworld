package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.Grammar.GrammarDto;
import com.example.EngWorldBackend.DTO.Grammar.GrammarResponse;
import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;
import com.example.EngWorldBackend.Persistence.DAO.GrammarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GrammarMapper {

    @Autowired
    private GrammarTypeRepository grammarTypeRepository;

    public static GrammarDto toDTO(Grammar grammar) {
        GrammarDto dto = new GrammarDto();
        dto.setGrammarId(grammar.getGrammarId());
        dto.setGrammarTitle(grammar.getGrammarTitle());
        dto.setGrammarDes(grammar.getGrammarDes());
        dto.setGrammarExample(grammar.getGrammarExample());
        dto.setRecipe(grammar.getRecipe());
        if (grammar.getGrammarType() != null) {
            dto.setGrammarType(grammar.getGrammarType().getTypeName());
        }
        return dto;
    }

    public Grammar toEntity(GrammarDto dto) {
        Grammar grammar = new Grammar();
        grammar.setGrammarId(dto.getGrammarId());
        grammar.setGrammarTitle(dto.getGrammarTitle());
        grammar.setGrammarDes(dto.getGrammarDes());
        grammar.setGrammarExample(dto.getGrammarExample());
        grammar.setRecipe(dto.getRecipe());
        if (dto.getGrammarType() != null) {
            GrammarType type = grammarTypeRepository.findByTypeName(dto.getGrammarType());
            grammar.setGrammarType(type);
        }
        return grammar;
    }

    public static GrammarResponse mapToGrammarResponse(List<GrammarDto> grammarDtos, Page<Grammar> grammars) {
        GrammarResponse grammarResponse = new GrammarResponse();
        grammarResponse.setContent(grammarDtos);
        grammarResponse.setPageNumber(grammars.getNumber());
        grammarResponse.setPageSize(grammars.getSize());
        grammarResponse.setTotalElements(grammars.getTotalElements());
        grammarResponse.setTotalPages(grammars.getTotalPages());
        grammarResponse.setLast(grammars.isLast());

        return grammarResponse;
    }
}

