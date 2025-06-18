package com.autoever.sample_jpa_mysql.service;

import com.autoever.sample_jpa_mysql.dto.MemberReqDto;
import com.autoever.sample_jpa_mysql.dto.MemberResDto;
import com.autoever.sample_jpa_mysql.dto.SignUpReqDto;
import com.autoever.sample_jpa_mysql.dto.TokenDto;
import com.autoever.sample_jpa_mysql.entity.Member;
import com.autoever.sample_jpa_mysql.jwt.TokenProvider;
import com.autoever.sample_jpa_mysql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j  // Log 정보를 출력하기 위한 롬복의 어노테이션
@Service    // Spring Container에 Bean 등록
@Transactional  // 여러개의 물리적 작업 단위를 논리적 단위로 묶음
@RequiredArgsConstructor    // 생성자를 자동 생성
public class AuthService {

    private final AuthenticationManagerBuilder managerBuilder; // 인증을 담당하는 클래스
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    // 회원 가입
    public MemberResDto signup(MemberReqDto memberReqDto) {
        if (memberRepository.existsByEmail(memberReqDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }
        Member member = memberReqDto.toEntity(passwordEncoder);
        return MemberResDto.of(memberRepository.save(member));
    }
    // 로그인
    public TokenDto login(MemberReqDto memberReqDto) {
        UsernamePasswordAuthenticationToken authenticationToken = memberReqDto.toAuthentication();
        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
        return tokenProvider.generateTokenDto(authentication);
    }

    // accessToken 재발급
/*    private final MemberRepository memberRepository;    // 생성자를 통한 의존성 주입

    // @RequiredArgConstructor가 아래 생성자 대체
    *//*AuthService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }*//*

    // 회원 가입 여부 확인
    public boolean isMember(String email) {
        return memberRepository.existsByEmail(email);
    }

    // 회원 가입
    public boolean signup(SignUpReqDto signUpReqDto) {
        try {
            Member member = convertDtoToEntity(signUpReqDto);
            memberRepository.save(member);
            return true;
        } catch (Exception e) {
            log.error("회원 가입 시 오류 발생 : {}", e.getMessage());
            return false;
        }
    }

    // 로그인
    public boolean login(String email, String pwd) {
        Optional<Member> member = memberRepository.findByEmailAndPwd(email, pwd);
        return member.isPresent();  // 객체 존재 여부 확인
    }

    // DTO -> Entity Mapping
    private Member convertDtoToEntity(SignUpReqDto signUpReqDto) {
        Member member = new Member();
        member.setEmail(signUpReqDto.getEmail());
        member.setPwd(signUpReqDto.getPwd());
        member.setName(signUpReqDto.getName());
        return member;
    }*/
}
