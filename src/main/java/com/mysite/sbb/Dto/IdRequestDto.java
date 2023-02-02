package com.mysite.sbb.Dto;

//import com.mysite.sbb.createId.Authority;
//import com.mysite.sbb.createId.CreateId;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class IdRequestDto {
//
//    private String name;
//
//
//    private String email;
//    private String password;
//    private String career;
//
//    private String gender;
//
//    private Integer age;
//
//    public CreateId toMember(PasswordEncoder passwordEncoder) {
//        return CreateId.builder()
//                .name(name)
//                .email(email)
//                .password(passwordEncoder.encode(password))
//                .career(career)
//                .age(age)
//                .authority(Authority.ROLE_USER)
//                .build();
//    }
//
//    public UsernamePasswordAuthenticationToken toAuthentication() {
//        return new UsernamePasswordAuthenticationToken(name, password);
//    }
//}