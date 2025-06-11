package com.autoever.sample_jpa_mysql.controller;

import com.autoever.sample_jpa_mysql.dto.MemberReqDto;
import com.autoever.sample_jpa_mysql.dto.MemberResDto;
import com.autoever.sample_jpa_mysql.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    /** 회원 전체 조회 */
    @GetMapping("/list")
    public ResponseEntity<List<MemberResDto>> memberList() {
        List<MemberResDto> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    /** 회원 상세 조회 */
    @GetMapping("/{email}")
    public ResponseEntity<MemberResDto> getMember(@PathVariable String email) {
        MemberResDto member = memberService.findByEmail(email);
        return ResponseEntity.ok(member);
    }

    /** 회원 수정 */
    @PutMapping("/{email}")
    public ResponseEntity<Boolean> modifyMember(@PathVariable String email, @RequestBody MemberReqDto memberReqDto) {
        boolean isSuccess = memberService.modifyMember(email, memberReqDto);
        return ResponseEntity.ok(isSuccess);
    }

    /** 회원 삭제 */
    @DeleteMapping("/{email}")
    public ResponseEntity<Boolean> deleteMember(@PathVariable String email) {
        boolean isSuccess = memberService.deleteMember(email);
        return ResponseEntity.ok(isSuccess);
    }
}
