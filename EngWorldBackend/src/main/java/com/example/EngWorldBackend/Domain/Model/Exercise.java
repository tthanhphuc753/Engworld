package com.example.EngWorldBackend.Domain.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseId;
    private String exerciseTitle;
    private String level;
    private String exerciseContent;
    private String totalQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", nullable = false)
    private Categories category;

    @OneToMany(mappedBy = "exerciseId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questionList;
}
