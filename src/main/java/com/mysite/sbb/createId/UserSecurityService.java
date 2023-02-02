package com.mysite.sbb.createId;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//@Service
//public class UserSecurityService implements UserDetailsService {
//
//    @Autowired
//    private IdRepo idRepository;
//
//    @Override
//    public CreateId loadUserByUsername(String username) throws UsernameNotFoundException {
//        return idRepository.findByName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
//    }
//}