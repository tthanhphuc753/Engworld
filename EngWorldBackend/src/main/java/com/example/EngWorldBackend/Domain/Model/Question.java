package com.example.EngWorldBackend.Domain.Model;

import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
import com.example.EngWorldBackend.Domain.Model.User.User;
import com.example.EngWorldBackend.Domain.Model.Vocab.Vocabulary;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private Long questionText;
    private String correctAnswer;
    private String op1;
    private String op2;
    private String op3;

    @OneToOne
    @JoinColumn(name = "vocabId")
    private Vocabulary vocab;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grammarId", nullable = false)
    private Grammar grammarId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseId", nullable = false)
    private Exercise exerciseId;

}
