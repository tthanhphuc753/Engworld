package com.example.EngWorldBackend.Persistence.DAO;

import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary,Long> {

    public Page<Vocabulary> findByTopic(VocabularyTopic vocabularyTopic, Pageable pageable);
    public Vocabulary findByVocabWord(String vocabWord);
}
