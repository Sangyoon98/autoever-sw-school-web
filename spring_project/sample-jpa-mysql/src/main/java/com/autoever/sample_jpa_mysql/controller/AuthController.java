package com.autoever.sample_jpa_mysql.controller;

import com.autoever.sample_jpa_mysql.dto.MemberLoginReqDto;
import com.autoever.sample_jpa_mysql.dto.MemberRegDto;
import com.autoever.sample_jpa_mysql.dto.MemberResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j  // Log 메시지 출력을 위한 어노테이션
@RestController
@RequestMapping("/auth")
public class AuthController {
    // 1.1 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<MemberResDto> signup(@RequestBody MemberRegDto memberRegDto) {
        log.info("member : {}", memberRegDto);
        MemberResDto memberResDto = new MemberResDto();
        memberResDto.setEmail(memberRegDto.getEmail());
        memberResDto.setName(memberRegDto.getName());
        memberResDto.setPwd(memberRegDto.getPwd());
        memberResDto.setImage("/test/test.img");
        memberResDto.setRegDate(LocalDateTime.now());

        return ResponseEntity.ok(memberResDto);
    }

    // 1.2 로그인
    // Post 방식 : email, pwd를 Request Body 형식으로 수신
    // 응답은 boolean 값으로 응답
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody MemberLoginReqDto memberLoginReqDto) {
        log.info("login : {}", memberLoginReqDto);
        return ResponseEntity.ok(true);
    }

    // 1.3 회원 조회
    // Get 방식 : email이 있으면 해당 회원 조회
    // 없으면 전체 회원 조회
    // 단 회원 정보 리스트는 서비스 로직과 DB가 없으므로 for 문으로 자체 생성
    private final List<MemberResDto> list = new ArrayList<>();

    private List<MemberResDto> generateMember() {
        for (int i = 0; i < 20; i++) {
            MemberResDto memberResDto = new MemberResDto();
            memberResDto.setEmail("qlrqod123123" + i + "@naver.com");
            memberResDto.setImage("image/test" + i + ".img");
            memberResDto.setPwd("qwer1234" + i);
            memberResDto.setName("채상윤" + i);
            memberResDto.setRegDate(LocalDateTime.now());
            list.add(memberResDto);
        }
        return list;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getMember(@RequestParam(required = false) String email) {
        log.error("email : {}", email);
        List<MemberResDto> ls = generateMember();
        if (email == null || email.isBlank()){
            return ResponseEntity.ok(ls);
        }
        for (MemberResDto memberResDto : ls) {
            if (memberResDto.getEmail().equals(email)) {
                return ResponseEntity.ok(memberResDto);
            }
        }
        return ResponseEntity.notFound().build();   // 404
    }
}
