package com.example.EngWorldBackend.Persistence.DAO;


import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrammarRepository extends JpaRepository<Grammar, Long> {


    List<Grammar> findByGrammarType(GrammarType grammarType);

}
