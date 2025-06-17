package com.autoever.spring_jdbc.controller;

import com.autoever.spring_jdbc.dto.MemberDto;
import com.autoever.spring_jdbc.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    // 회원 전체 조회
    @GetMapping("/list")
    public ResponseEntity<List<MemberDto>> memberList() {
        List<MemberDto> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    // 이메일 회원 조회
    @GetMapping("/{email}")
    public ResponseEntity<MemberDto> getMember(@PathVariable String email) {
        MemberDto member = memberService.findByEmail(email);
        return ResponseEntity.ok(member);
    }

    // 회원 추가
    @PostMapping("/add")
    public ResponseEntity<Boolean> insert(@RequestBody MemberDto memberDto) {
        boolean isSuccess = memberService.insert(memberDto);
        return ResponseEntity.ok(isSuccess);
    }

    // 회원 수정
    @PutMapping("/{email}")
    public ResponseEntity<Boolean> modify(@PathVariable String email, @RequestBody MemberDto memberDto) {
        boolean isSuccess = memberService.update(email, memberDto);
        return ResponseEntity.ok(isSuccess);
    }

    // 회원 삭제
    @DeleteMapping("/{email}")
    public ResponseEntity<Boolean> delete(@PathVariable String email) {
        boolean isSuccess = memberService.delete(email);
        return ResponseEntity.ok(isSuccess);
    }
}
