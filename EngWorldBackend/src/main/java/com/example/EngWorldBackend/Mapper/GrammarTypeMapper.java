package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.GrammarTypeDto;
import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;

public class GrammarTypeMapper {
    public static GrammarTypeDto toDTO(GrammarType grammarType) {
        GrammarTypeDto dto = new GrammarTypeDto();
        dto.setGrammarTypeId(grammarType.getGrammarTypeId());
        dto.setTypeName(grammarType.getTypeName());
        dto.setTypeDes(grammarType.getTypeDes());
        return dto;
    }

    public static GrammarType toEntity(GrammarTypeDto dto) {
        GrammarType grammarType = new GrammarType();
        grammarType.setGrammarTypeId(dto.getGrammarTypeId());
        grammarType.setTypeName(dto.getTypeName());
        grammarType.setTypeDes(dto.getTypeDes());
        return grammarType;
    }
}
