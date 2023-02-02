package com.mysite.sbb.createId;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.*;


@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PACKAGE)

public class CreateId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userIdx;
    @Column(unique = true)
    private String name;
    @Column
    private String pw;

    @Column(unique = true)
    private String email;

    @Column
    private String career;
    @Column
    private String gender;
    @Column
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public CreateId (String name, String password,String email,String career,String gender,Integer age,Authority authority) {
        this.name = name;
        this.pw = password;
        this.email=email;
        this.career=career;
        this.gender=gender;
        this.age=age;
        this.authority = authority;
    }

}