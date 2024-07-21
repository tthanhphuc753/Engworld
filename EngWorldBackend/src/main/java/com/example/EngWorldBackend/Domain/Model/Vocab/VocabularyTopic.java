package com.example.EngWorldBackend.Domain.Model.Vocab;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vocabTopicId;
    private String topicName;


    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vocabulary> vocab;

}
