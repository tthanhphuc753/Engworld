package com.example.EngWorldBackend.Domain.Service.VocabularyService;

import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface VocabularyService {

    Vocabulary createVocab(Vocabulary newVocab);

    public Optional<Vocabulary> getVocabById(Long id);

    public Page<Vocabulary> getAllVocab(int pageNumber, int pageSize);

    public void deleteVocabById(Long id);

    public Vocabulary updateVocabById(Long id, Vocabulary vocabulary) throws Exception;

    public Page<Vocabulary> getAllVocabByTopic(Long topicId, int pageNumber, int pageSize);

    public Vocabulary findByWord(String vocabWord);


    void addVocabFromExcel(InputStream inputStream) throws IOException;
}
