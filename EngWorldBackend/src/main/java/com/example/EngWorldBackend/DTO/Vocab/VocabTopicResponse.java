package com.example.EngWorldBackend.DTO.Vocab;

import com.example.EngWorldBackend.Domain.Respones.PagedResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class VocabTopicResponse extends PagedResponse<VocabularyTopicDto> {

}
