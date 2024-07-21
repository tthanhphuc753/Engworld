package com.example.EngWorldBackend.Persistence.DAO;

import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import com.example.EngWorldBackend.Domain.Model.Vocab.VocabularyTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VocabularyTopicRepository extends JpaRepository<VocabularyTopic,Long> {


    VocabularyTopic findByTopicName(String topicName);
}
