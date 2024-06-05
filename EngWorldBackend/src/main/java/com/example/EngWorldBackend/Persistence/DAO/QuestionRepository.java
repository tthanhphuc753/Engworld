package com.example.EngWorldBackend.Persistence.DAO;


import com.example.EngWorldBackend.Domain.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    public List<Question> findAllByGrammarId(Long id);
    public List<Question> findAllByExerciseId(Long id);

}
