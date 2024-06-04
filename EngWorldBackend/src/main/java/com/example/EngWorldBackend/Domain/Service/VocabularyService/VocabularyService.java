package com.example.EngWorldBackend.Domain.Service.VocabularyService;

import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;

import java.util.List;
import java.util.Optional;

public interface VocabularyService {

    Vocabulary createVocab(Vocabulary newVocab);

    public Optional<Vocabulary> getVocabById(Long id);
    public List<Vocabulary> getAllVocab();
    public void deleteVocabById(Long id);
    public Vocabulary updateVocabById(Long id, Vocabulary vocabulary) throws Exception;
    public List<Vocabulary> getAllVocabByTopic(Long topicId);

}
