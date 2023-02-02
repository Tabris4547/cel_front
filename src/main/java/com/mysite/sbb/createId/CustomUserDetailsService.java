package com.mysite.sbb.createId;

//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//    private final IdRepo memberRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return memberRepository.findByName(username)
//                .map(this::createUserDetails)
//                .orElseThrow(() -> new UsernameNotFoundException(username + " 을 DB에서 찾을 수 없습니다"));
//    }
//
//    private UserDetails createUserDetails(CreateId member) {
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getAuthority().toString());
//
//        return new User(
//                String.valueOf(member.getName()),
//                member.getPw(),
//
//                Collections.singleton(grantedAuthority)
//        );
//    }
//}