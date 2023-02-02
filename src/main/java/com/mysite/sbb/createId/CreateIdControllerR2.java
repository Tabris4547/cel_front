package com.mysite.sbb.createId;

import com.mysite.sbb.createStudy.*;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mysite.sbb.createStudy.studyService;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.data.annotation.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Null;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class CreateIdControllerR2 {

    private final CreateIdService createIdService;
    private final studyService studySer;
    private final studyRepo sRepo;

    private  final IdRepo idRepo;

    @GetMapping("/signup")
    public void sign_r2() {


    }
    //회원가입
    @PostMapping("/signup")
    public String signup_r2(@RequestBody CreateIDDTO newUser,BindingResult bindingResult)
    {

        if (bindingResult.hasErrors()) {
            return "error";
        }
        try {
            createIdService.CreateR2(newUser.getName(),
                    newUser.getPassword1(),newUser.getEmail(),newUser.getCareer(),newUser.getGender(),newUser.getAge());
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "already";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "error";
        }
        return "Yes";
    }



    //로그인
    @GetMapping("/login")
    public void login_r2() {

    }
    @PostMapping("/login")
    public CreateId login_r2(@RequestBody LoginDto params) {
        CreateId entity = idRepo.findByNameAndPw(params.getName(),params.getPw());
        return entity;
    }
    @GetMapping("/hello")
    public List<String> he() {
        return Arrays.asList("안녕하세요", "Hello");
    }

//    @PostMapping("/test/signup")
//    public ResponseEntity<IdResponseDto> signup_test(@RequestBody IdRequestDto requestDto) {
//        return ResponseEntity.ok(createIdService.signup(requestDto));
//    }
//
//    @PostMapping("/test/login")
//    public ResponseEntity<TokenDto> login_test(@RequestBody IdRequestDto requestDto) {
//        return ResponseEntity.ok(createIdService.login(requestDto));
//    }
}
