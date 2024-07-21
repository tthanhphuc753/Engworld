package com.example.EngWorldBackend.Domain.Model.Grammar;


import com.example.EngWorldBackend.Domain.Model.Question;
import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Grammar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grammarId;
    private String grammarTitle;
    private String grammarDes;
    private String grammarExample;
    private String recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grammarTypeId", nullable = false)
    private GrammarType grammarType;

    @OneToMany(mappedBy = "grammar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questionList;

}
