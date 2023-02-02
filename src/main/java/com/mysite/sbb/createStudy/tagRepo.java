package com.mysite.sbb.createStudy;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface tagRepo extends JpaRepository<Tags, Integer> {
}