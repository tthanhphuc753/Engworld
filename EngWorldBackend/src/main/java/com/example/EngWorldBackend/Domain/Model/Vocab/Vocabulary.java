package com.example.EngWorldBackend.Domain.Model.Vocab;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vocabId;
    private String vocabWord;
    private String vocabMeaning;
    private String vocabIPA;
    private String vocabExample;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vocabTopicId", nullable = false)
    private VocabularyTopic topic ;

    public Vocabulary(String word, String meaning, String iPA, String example, VocabularyTopic vocabularyTopic) {
        this.vocabWord = word;
        this.vocabExample = example;
        this.vocabIPA = iPA;
        this.vocabMeaning=meaning;
        this.topic = vocabularyTopic;
    }
}
