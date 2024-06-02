package com.example.EngWorldBackend.Domain.Model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    private String courseLevel;
    private String courseDes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryId",nullable = false)
    private Categories category;

}
