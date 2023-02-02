package com.mysite.sbb.createStudy;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mysite.sbb.createId.CreateId;
import org.springframework.data.jpa.repository.JpaRepository;
public interface studyRepo extends JpaRepository<Study, Integer> {
    List<Study> findByAuthor(CreateId author);
    Page<Study> findAll(Pageable pageable);
}