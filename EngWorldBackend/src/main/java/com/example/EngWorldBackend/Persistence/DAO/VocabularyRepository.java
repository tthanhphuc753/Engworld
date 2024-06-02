package com.example.EngWorldBackend.Persistence.DAO;

import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary,Long> {

    public List<Vocabulary> findAllByTopic(Long id);

}
