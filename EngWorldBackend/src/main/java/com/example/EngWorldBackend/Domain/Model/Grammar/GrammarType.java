package com.example.EngWorldBackend.Domain.Model.Grammar;

import com.example.EngWorldBackend.Domain.Model.Question;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrammarType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grammarTypeId;
    private String typeName;
    private String typeDes;

    @OneToMany(mappedBy = "grammarType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grammar> grammar;
}
