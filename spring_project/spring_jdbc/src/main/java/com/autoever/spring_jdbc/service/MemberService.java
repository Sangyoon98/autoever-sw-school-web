package com.autoever.spring_jdbc.service;

import com.autoever.spring_jdbc.dao.MemberDao;
import com.autoever.spring_jdbc.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;

    // 회원 전체 조회
    public List<MemberDto> findAll() {
        return memberDao.findAll();
    }

    // 이메일로 회원 조회
    public MemberDto findByEmail(String email) {
        MemberDto result = memberDao.findByEmail(email);
        if (result == null) throw new RuntimeException("해당 이메일이 존재하지 않습니다.");
        return result;
    }

    // 회원 추가
    public boolean insert(MemberDto memberDto) {
        return memberDao.insert(memberDto) > 0;
    }

    // 회원 수정
    public boolean update(String email, MemberDto memberDto) {
        return memberDao.update(email, memberDto) > 0;
    }

    // 회원 삭제
    public boolean delete(String email) {
        return memberDao.delete(email) > 0;
    }
}