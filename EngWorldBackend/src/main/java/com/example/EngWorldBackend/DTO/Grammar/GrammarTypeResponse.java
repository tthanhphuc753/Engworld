package com.example.EngWorldBackend.DTO.Grammar;

import com.example.EngWorldBackend.Domain.Respones.PagedResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GrammarTypeResponse extends PagedResponse<GrammarTypeDto> {
    private List<GrammarTypeDto> content;

}
