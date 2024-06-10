package com.example.EngWorldBackend.Persistence.DAO;


import com.example.EngWorldBackend.Domain.Model.Exercise;
import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    public Page<Question> findByGrammar(Grammar grammar, Pageable pageable);

    public Page<Question> findByExercise(Exercise exercise, Pageable pageable);

}
