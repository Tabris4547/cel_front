package com.mysite.sbb.JWT;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import javax.persistence.criteria.CriteriaBuilder;
//
//public class SecurityUtil {
//
//    private SecurityUtil() { }
//
//    public static Integer getCurrentMemberId() {
//        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || authentication.getName() == null) {
//            throw new RuntimeException("Security Context에 인증 정보가 없습니다.");
//        }
//
//        return Integer.parseInt(authentication.getName());
//    }
//}