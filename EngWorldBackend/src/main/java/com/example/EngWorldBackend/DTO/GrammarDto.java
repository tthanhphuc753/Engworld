package com.example.EngWorldBackend.DTO;

import lombok.Data;
import lombok.Value;

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
}