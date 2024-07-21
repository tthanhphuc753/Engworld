package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.Grammar.GrammarTypeDto;
import com.example.EngWorldBackend.DTO.Grammar.GrammarTypeResponse;
import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;
import org.springframework.data.domain.Page;

import java.util.List;

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

    public static GrammarTypeResponse mapToGrammarTypeResponse(List<GrammarTypeDto> grammarTypeDtos, Page<GrammarType> grammarTypes) {
        GrammarTypeResponse grammarTypeResponse = new GrammarTypeResponse();
        grammarTypeResponse.setContent(grammarTypeDtos);
        grammarTypeResponse.setPageNumber(grammarTypes.getNumber());
        grammarTypeResponse.setPageSize(grammarTypes.getSize());
        grammarTypeResponse.setTotalElements(grammarTypes.getTotalElements());
        grammarTypeResponse.setTotalPages(grammarTypes.getTotalPages());
        grammarTypeResponse.setLast(grammarTypes.isLast());

        return grammarTypeResponse;
    }
}
