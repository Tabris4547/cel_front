package com.mysite.sbb.createId;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdRepo extends JpaRepository<CreateId, Integer> {

    Optional <CreateId> findByName(String name);


    boolean existsByName(String name);
    CreateId findByNameAndPw(final String name, final String passwd);
}