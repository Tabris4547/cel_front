package com.mysite.sbb.createStudy;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.mysite.sbb.createId.*;
import com.mysite.sbb.createId.IdRepo;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/study")
public class studyControllerR2 {
    private final IdRepo idRepo;

    private final CreateIdService userService;
    private final studyService studySer;
    private final tagService tagSer;

    private final studyRepo sRepo;
    private final tagRepo tRepo;
    //스터디 작성
    @GetMapping("/write")
    public String writeR2()
    {
        return "YES";
    }
    //스터디 작성
    @PostMapping("/write")
    public String writeR2(@RequestBody StudyDto newStudy,BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "error";
        }

        Study now=studySer.createR2(newStudy.getStudyName(),
                newStudy.getStudyIntro(),newStudy.getStudyRule(),newStudy.getStudyMentor(),newStudy.getUserName());
        Integer num = now.getStudyId();
        tagSer.create(num, newStudy.getWord1(), newStudy.getWord2(),newStudy.getWord3());

        return "Yes";
    }
    //목록보기
    @GetMapping("/list")
    public List<Study> listR2()  {
        this.studySer.update();

        List<Study> studyList = this.sRepo.findAll();
        return studyList;
    }

    @GetMapping("/list/count")
    public Page<Study> count()  {


        Page<Study> studyList = this.studySer.findAllCount();
        return studyList;
    }
    @GetMapping("/list/page:{id}")
    public Page<Study> listR2(Model model, @RequestParam(value="page", defaultValue="0") int page)  {
        this.studySer.update();

        Page<Study> studypage = this.studySer.getPage(page);


        return studypage;
    }
}
