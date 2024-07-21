package com.example.EngWorldBackend.DTO.Grammar;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.EngWorldBackend.Domain.Model.Grammar.Grammar}
 */
@Data
public class GrammarDto implements Serializable {
    Long grammarId;
    String grammarTitle;
    String grammarDes;
    String grammarExample;
    String recipe;
    String grammarType;
}