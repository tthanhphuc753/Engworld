package com.example.EngWorldBackend.Persistence.DAO;


import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Model.Grammar.GrammarType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrammarRepository extends JpaRepository<Grammar, Long> {


    Page<Grammar> findByGrammarType(GrammarType grammarType, Pageable pageable);

}
