package com.mysite.sbb.createId;
import java.lang.Integer;
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CreateIdService {
    private final IdRepo IdRepository;
//    private final AuthenticationManagerBuilder managerBuilder;
//
//    private final PasswordEncoder passwordEncoder;
//    private final TokenProvider tokenProvider;
//
//
//    public IdResponseDto findMemberInfoById(Integer memberId) {
//        return IdRepository.findById(memberId)
//                .map(IdResponseDto::of)
//                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
//    }
//
//    public IdResponseDto findMemberInfoByName(String name) {
//        return IdRepository.findByName(name)
//                .map(IdResponseDto::of)
//                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
//    }


    public void CreateR2(String username, String password, String email, String career,String gender,Integer age) {
        CreateId user = new CreateId();

        user.setName(username);
        user.setPw(password);
        user.setEmail(email);
        user.setCareer(career);
        user.setGender(gender);
        user.setAge(age);
        this.IdRepository.save(user);
    }

    public CreateId create(String username, String password, String email, String career,String gender,Integer age) {
        CreateId user = new CreateId();

        user.setName(username);
        user.setPw(password);
        user.setEmail(email);
        user.setCareer(career);
        user.setGender(gender);
        user.setAge(age);
        this.IdRepository.save(user);

        return user;
    }
    public CreateId getUser(String username) {
        Optional<CreateId> siteUser = this.IdRepository.findByName(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }

    public void modifyUser(CreateId SiteUser,String name,String pw,String email,String gender,String career,Integer age)
    {
        SiteUser.setName(name);
        SiteUser.setPw(pw);
        SiteUser.setEmail(email);
        SiteUser.setCareer(career);
        SiteUser.setAge(age);

        this.IdRepository.save(SiteUser);
    }


//    public CreateId findByname(String Name)
//    {
//        CreateId entity = this.IdRepository.findByName(Name);
//
//        return entity;
//    }

//    public IdResponseDto signup(IdRequestDto requestDto) {
//        if (IdRepository.existsByName(requestDto.getName())) {
//            throw new RuntimeException("이미 가입되어 있는 유저입니다");
//        }
//
//        CreateId member = requestDto.toMember(passwordEncoder);
//        return IdResponseDto.of(IdRepository.save(member));
//    }
//
//    public TokenDto login(IdRequestDto requestDto) {
//        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
//
//        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
//
//        return tokenProvider.generateTokenDto(authentication);
//    }
//
//
//    public IdResponseDto getMyInfoBySecurity() {
//        return IdRepository.findById(SecurityUtil.getCurrentMemberId())
//                .map(IdResponseDto::of)
//                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
//    }

//    @Transactional
//    public IdResponseDto changeMemberNickname(String email, String nickname) {
//        CreateId member = IdRepository.findByName(name).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
//        member.setNickname(nickname);
//        return MemberResponseDto.of(memberRepository.save(member));
//    }

//    @Transactional
//    public IdResponseDto changeMemberPassword(String email, String exPassword, String newPassword) {
//        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
//        if (!passwordEncoder.matches(exPassword, member.getPassword())) {
//            throw new RuntimeException("비밀번호가 맞지 않습니다");
//        }
//        member.setPassword(passwordEncoder.encode((newPassword)));
//        return MemberResponseDto.of(memberRepository.save(member));
//    }

}
