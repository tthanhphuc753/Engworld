package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.GrammarDto;
import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;
import com.example.EngWorldBackend.Persistence.DAO.GrammarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrammarMapper {

    @Autowired
    private  GrammarTypeRepository grammarTypeRepository;

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
}

