package com.mysite.sbb.createId;
import com.mysite.sbb.createStudy.*;
import java.lang.Integer;
import java.security.Principal;
import javax.validation.Valid;
import java.util.List;
import com.mysite.sbb.createStudy.studyService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class CreateIdController {

    private final CreateIdService createIdService;
    private final studyService studySer;
    private final studyRepo sRepo;

    @Qualifier("BCryptPasswordEncoder")


    //회원가입
    @GetMapping("/signup")
    public String signup(CreateIdForm createIdForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid CreateIdForm createIdForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!createIdForm.getPassword1().equals(createIdForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }


        try {
            createIdService.create(createIdForm.getUsername(),
                    createIdForm.getPassword1(),createIdForm.getEmail(),createIdForm.getCareer(),createIdForm.getGender(),createIdForm.getAge());
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }
        return "redirect:/";
    }
    //로그인
    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

    //마이페이지 들어가기전에 비밀번호 재확인하는 페이지
    //뭔가 잘 안되서 일단 유보

//    @PreAuthorize("isAuthenticated()")
//    @GetMapping("/mypage")
//    public String getmyPageIntro(checkForm cForm) {
//        return "check_form";
//    }
//    @PreAuthorize("isAuthenticated()")
//    @PostMapping("/mypage")
//    public String getmyPageIntro(@Valid checkForm cForm, BindingResult indingResult,Principal principal)
//    {
//
//        CreateId siteUser = this.createIdService.getUser(principal.getName());
//        String pw=siteUser.getPw();
//        String put=cForm.getOldpassword();
//        if (bindingResult.hasErrors()) {
//            return "check_form";
//        }
//
//        if (!passwordEncoder.matches(pw,put)) {
//            bindingResult.rejectValue("oldpassword", "passwordInCorrect",
//                    "패스워드가 일치하지 않습니다.");
//            return "check_form";
//        }
//        return "redirect:/mypage/ok";
//    }
    //마이페이지

    @GetMapping("/mypage")
    public String mypage(Model model,Principal principal)
    {
        CreateId siteUser = this.createIdService.getUser(principal.getName());
        List<Study> studyList = this.sRepo.findByAuthor(siteUser);

        model.addAttribute("studyList", studyList);
        model.addAttribute("me",siteUser);
        model.addAttribute("Principal",principal);
        return "myPage";
    }

    @GetMapping("/modify/{id}")
    public String modify(CreateIdForm createIdFormForm,Model model,Principal principal)
    {
        return "userupdateForm";
    }



    @PostMapping("/modify/{id}")
    public String modify(@Valid CreateIdForm createIdForm ,Model model,Principal principal,BindingResult bindingResult,RedirectAttributes rttr)
    {
        CreateId siteUser = this.createIdService.getUser(principal.getName());

        if (!createIdForm.getPassword1().equals(createIdForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "userupdateForm";
        }


        try {
            createIdService.modifyUser(siteUser,createIdForm.getUsername(),
                    createIdForm.getPassword1(),createIdForm.getEmail(),createIdForm.getCareer(),createIdForm.getGender(),createIdForm.getAge());
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "userupdateForm";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "userupdateForm";
        }

        CreateId nUser = this.createIdService.getUser(principal.getName());
        List<Study> studyList = this.sRepo.findByAuthor(nUser);
        for(Study s:studyList)
        {
            this.studySer.modify_name(s,nUser);
        }

        return "redirect:/user/modify/logout";
    }





}