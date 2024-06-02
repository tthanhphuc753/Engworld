package com.example.EngWorldBackend.Persistence.DAO;


import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrammarRepository extends JpaRepository<Grammar,Long> {

    public Grammar getGrammarByGrammarType(Long id);
}
