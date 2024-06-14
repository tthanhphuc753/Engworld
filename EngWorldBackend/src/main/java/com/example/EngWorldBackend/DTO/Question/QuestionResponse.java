package com.example.EngWorldBackend.DTO.Question;

import com.example.EngWorldBackend.Domain.Respones.PagedResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionResponse extends PagedResponse<QuestionDto> {

}
