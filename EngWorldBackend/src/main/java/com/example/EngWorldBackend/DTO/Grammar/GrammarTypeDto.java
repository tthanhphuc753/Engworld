package com.example.EngWorldBackend.DTO.Grammar;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType}
 */
@Data
public class GrammarTypeDto implements Serializable {
    Long grammarTypeId;
    String typeName;
    String typeDes;
}