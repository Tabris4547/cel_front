package com.mysite.sbb.createStudy;
import java.time.LocalDate;
import com.mysite.sbb.createId.CreateId;
import java.time.Period;
import java.util.List;
import com.mysite.sbb.createStudy.Tags;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studyId;

    @Column(unique = true)
    private String studyName;

    @Column
    private String studyIntro;

    @Column
    private String studyRule;

    @Column
    private String mentor;
    @Column
    private LocalDate createDate;

    @Column
    private Integer days;

    @ManyToOne
    private  CreateId author;
    private Integer Score;
}
