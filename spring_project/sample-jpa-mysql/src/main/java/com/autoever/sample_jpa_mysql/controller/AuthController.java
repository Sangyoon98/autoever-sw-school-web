package com.autoever.sample_jpa_mysql.controller;

import com.autoever.sample_jpa_mysql.dto.*;
import com.autoever.sample_jpa_mysql.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j  // Log 메시지 출력을 위한 어노테이션
@RestController // REST API (GET, POST, PUT, DELETE)
@RequiredArgsConstructor    // 생성자를 통한 의존성 주입을 받기 위해 생성자를 자동 생성
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResDto> signup(@RequestBody MemberReqDto memberReqDto) {
        return ResponseEntity.ok(authService.signup(memberReqDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberReqDto memberReqDto) {
        return ResponseEntity.ok(authService.login(memberReqDto));
    }
/*    private final AuthService authService;

    *//** 회원 가입 여부 확인 *//*
    @GetMapping("/exists/{email}")  //  정보가 브라우저 주소창에 보여짐
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        boolean isExist = authService.isMember(email);
        return ResponseEntity.ok(!isExist);
    }

    *//** 회원 가입 *//*
    @PostMapping("/signup") // Body에 정보를 싣는 방식, 정보가 보여지지 않음
    public ResponseEntity<Boolean> signup(@RequestBody SignUpReqDto signUpReqDto) {
        boolean isSuccess = authService.signup(signUpReqDto);
        return ResponseEntity.ok(isSuccess);
    }

    *//** 로그인 *//*
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginReqDto loginReqDto) {
        boolean isSuccess = authService.login(loginReqDto.getEmail(), loginReqDto.getPwd());
        return ResponseEntity.ok(isSuccess);
    }*/
}
