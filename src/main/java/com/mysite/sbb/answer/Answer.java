package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.mysite.sbb.question.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}