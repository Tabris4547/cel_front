package com.mysite.sbb.question;


import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRespository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
}