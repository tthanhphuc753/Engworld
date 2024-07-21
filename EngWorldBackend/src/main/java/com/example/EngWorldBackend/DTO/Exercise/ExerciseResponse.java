package com.example.EngWorldBackend.DTO.Exercise;

import com.example.EngWorldBackend.Domain.Respones.PagedResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExerciseResponse extends PagedResponse<ExerciseDto> {

}
