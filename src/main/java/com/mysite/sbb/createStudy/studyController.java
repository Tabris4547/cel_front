package com.mysite.sbb.createStudy;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.mysite.sbb.createId.*;
import com.mysite.sbb.createId.IdRepo;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.dao.DataIntegrityViolationException;


import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
@RequestMapping("study")
public class studyController {
    private final IdRepo idRepo;

    private final CreateIdService userService;
    private final studyService studySer;
    private final tagService tagSer;

    private final studyRepo sRepo;
    private final tagRepo tRepo;
    //전체목록
    @GetMapping("/list")
    public String list(Model model) {
        this.studySer.update();
        List<Study> studyList = this.sRepo.findAll();
        model.addAttribute("studyList", studyList);

        return "study_list";
    }
    //자세히보기
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer Id,Principal principal)
    {
        this.studySer.update();
        Study study=this.studySer.getStudy(Id);
        Tags tag=this.tagSer.getTag(Id);



        model.addAttribute("study", study);
        model.addAttribute("tag",tag);
        model.addAttribute("Principal",principal);

        return "study_detail";
    }
    //만들기

    @GetMapping("/write")
    public String write(studyForm sForm) {
        return "study_form";
    }


    @PostMapping("/write")
    public String write(@Valid studyForm sForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "study_form";
        }
        CreateId siteUser = this.userService.getUser(principal.getName());
        Study now = studySer.create(sForm.getStudyName(), sForm.getStudyIntro(), sForm.getStudyRule(), sForm.getMentor(),siteUser);
        Integer num = now.getStudyId();
        tagSer.create(num, sForm.getKeyOne(), sForm.getKeyTwo(),sForm.getKeyThree());
        return "redirect:/study/list";
    }
    //수정하기

    @GetMapping("/modify/{id}")
    public String studyModify(studyForm sForm, @PathVariable("id") Integer id, Principal principal) {
        Study study = this.studySer.getStudy(id);
        if(!study.getAuthor().getName().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        Tags tags=this.tagSer.getTag(study.getStudyId());
        sForm.setStudyName(study.getStudyName());
        sForm.setStudyIntro(study.getStudyIntro());
        sForm.setStudyRule(study.getStudyRule());
        sForm.setMentor(study.getMentor());
        sForm.setKeyOne(tags.getTagOne());
        sForm.setKeyTwo(tags.getTagTwo());
        sForm.setKeyThree(tags.getTagThree());

        return "study_form";
    }
    //삭제하기

    @PostMapping("/modify/{id}")
    public String studyModify(@Valid studyForm sForm, BindingResult bindingResult,
                              Principal principal, @PathVariable("id") Integer id) {

        if (bindingResult.hasErrors()) {
            return "study_form";
        }
        Study study = this.studySer.getStudy(id);
        if (!study.getAuthor().getName().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.studySer.modify(study, sForm.getStudyName(), sForm.getStudyIntro(),sForm.getStudyRule(),sForm.getMentor());
        return String.format("redirect:/study/detail/%s", id);
    }


    @GetMapping("/delete/{id}")
    public String studyDelete(Principal principal, @PathVariable("id") Integer id) {
        Study study = this.studySer.getStudy(id);
        if (!study.getAuthor().getName().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.studySer.delete(study);
        return "redirect:/";
    }
}
