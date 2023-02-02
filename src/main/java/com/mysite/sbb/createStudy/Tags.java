package com.mysite.sbb.createStudy;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tags {


    @Id
    private Integer studyIdx;

    @Column
    private String  tagOne;
    private String  tagTwo;
    private String tagThree;


}
