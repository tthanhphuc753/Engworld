package com.example.EngWorldBackend.Domain.Model;

import com.example.EngWorldBackend.Domain.Model.Grammar.Grammar;
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
    private String questionText;
    private String correctAnswer;
    private String op1;
    private String op2;
    private String op3;

    @OneToOne
    @JoinColumn(name = "vocabId")
    private Vocabulary vocab;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grammarId", nullable = true)
    private Grammar grammar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseId", nullable = true)
    private Exercise exercise;

    public Question(String questionText, String correctAnswer
            , String op1, String op2, String op3, Vocabulary vocab
            , Grammar grammar, Exercise exercise) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.vocab = vocab;
        this.grammar = grammar;
        this.exercise = exercise;
    }
}
