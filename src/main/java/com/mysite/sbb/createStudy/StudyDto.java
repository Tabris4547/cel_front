package com.mysite.sbb.createStudy;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.*;


@Getter
@Setter

public class StudyDto {

    String studyName;
    String studyIntro;

    String studyRule;

    String studyMentor;


    String userName;

    String word1;

    String word2;

    String word3;


}
