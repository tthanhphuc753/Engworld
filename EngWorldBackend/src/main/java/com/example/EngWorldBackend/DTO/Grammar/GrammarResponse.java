package com.example.EngWorldBackend.DTO.Grammar;

import com.example.EngWorldBackend.Domain.Respones.PagedResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GrammarResponse extends PagedResponse<GrammarDto> {

}
