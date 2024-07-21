package com.example.EngWorldBackend.Domain.Service.VocabularyTopicService;

import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface VocabularyTopicService {
    VocabularyTopic createVocabularyTopic(VocabularyTopic newVocabTopic);

    Optional<VocabularyTopic> getVocabularyTopicById(Long id);

    Page<VocabularyTopic> getAllVocabularyTopic(int pageNumber, int pageSize);

    void deleteVocabularyTopicById(Long id);

    VocabularyTopic updateVocabularyTopicById(Long id, VocabularyTopic newVocabTopic);
}
