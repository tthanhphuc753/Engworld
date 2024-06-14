package com.example.EngWorldBackend.Domain.Model.Course;


import com.example.EngWorldBackend.Domain.Model.User.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_details")
@Getter
@Setter
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime payDate;
    private String bankCode;
    private long amount;
    private String cardType;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private Course course;

}
