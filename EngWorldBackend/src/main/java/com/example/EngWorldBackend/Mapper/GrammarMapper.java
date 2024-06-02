package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.GrammarDto;
import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;

public class GrammarMapper {
    public static GrammarDto toDTO(Grammar grammar) {
        GrammarDto dto = new GrammarDto();
        dto.setGrammarId(grammar.getGrammarId());
        dto.setGrammarTitle(grammar.getGrammarTitle());
        dto.setGrammarDes(grammar.getGrammarDes());
        dto.setGrammarExample(grammar.getGrammarExample());
        dto.setRecipe(grammar.getRecipe());
        return dto;
    }

    public static Grammar toEntity(GrammarDto dto) {
        Grammar grammar = new Grammar();
        grammar.setGrammarId(dto.getGrammarId());
        grammar.setGrammarTitle(dto.getGrammarTitle());
        grammar.setGrammarDes(dto.getGrammarDes());
        grammar.setGrammarExample(dto.getGrammarExample());
        grammar.setRecipe(dto.getRecipe());
        return grammar;
    }
}

