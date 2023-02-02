package com.mysite.sbb.createStudy;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.createId.CreateId;
import com.mysite.sbb.createId.CreateIdService;
import com.mysite.sbb.createId.IdRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class studyService {
    private final studyRepo studyReposi;
    private final IdRepo idRepo;
    private final CreateIdService idservce;

    public void update()
    {
        LocalDate no=LocalDate.now();
        List <Study> study=this.studyReposi.findAll();
        for (Study s:study)
        {
            LocalDate ct=s.getCreateDate();
            Period p=Period.between(ct,no);
            Integer day=p.getDays();
            s.setDays(day);
        }


    }

    public Study getStudy(Integer Id)
    {
        Optional<Study> study=this.studyReposi.findById(Id);
        if (study.isPresent())
        {
            return study.get();
        }
        else
        {
            throw new DataNotFoundException("study not found");
        }
    }
    public Study create(String name,String intro,String role,String mentor,CreateId id)
    {
        Study study=new Study();
        study.setStudyName(name);
        study.setStudyIntro(intro);
        study.setStudyRule(role);
        study.setMentor(mentor);
        study.setAuthor(id);
        study.setCreateDate(LocalDate.now());

        this.studyReposi.save(study);
        return study;
    }
    public void modify(Study study,String name,String intro,String rule,String mentor)
    {
        study.setStudyName(name);
        study.setStudyIntro(intro);
        study.setStudyRule(rule);
        study.setMentor(mentor);
        this.studyReposi.save(study);
    }
    public void delete(Study study)
    {
        this.studyReposi.delete(study);
    }
    public void modify_name(Study study,CreateId user)
    {
        study.setAuthor(user);
        this.studyReposi.save(study);
    }

    public Study createR2(String name,String intro,String role,String mentor,String user)
    {
        Study study=new Study();
        study.setStudyName(name);
        study.setStudyIntro(intro);
        study.setStudyRule(role);
        study.setMentor(mentor);

       CreateId id=idservce.getUser(user);

        study.setAuthor(id);
        study.setCreateDate(LocalDate.now());

        this.studyReposi.save(study);
        return study;
    }
    //페이지 넘기기
    public Page<Study> getPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.studyReposi.findAll(pageable);
    }

    //모든 페이지 넘기기
    public Page<Study> findAllCount() {

        Pageable pageable = PageRequest.of(1,1);
        return this.studyReposi.findAll(pageable);
    }

}
