package com.autoever.sample_jpa_mysql.service;

import com.autoever.sample_jpa_mysql.dao.MemberDao;
import com.autoever.sample_jpa_mysql.dto.MemberReqDto;
import com.autoever.sample_jpa_mysql.dto.MemberResDto;
import com.autoever.sample_jpa_mysql.entity.Member;
import com.autoever.sample_jpa_mysql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberDao memberDao;

    // 회원 전체 조회
    public List<MemberResDto> findAll() {
        List<Member> members = memberRepository.findAll();
        List<MemberResDto> memberDtos = new ArrayList<>();
        for(Member member : members) {
            memberDtos.add(convertEntityToDto(member));
        }
        return memberDtos;
    }

    // 회원 전체 조회 JPA
    /*public List<MemberResDto> findAll() {
        List<Member> members = memberRepository.findAll();  // DB의 정보를 Member Entity에 담음
        List<MemberResDto> memberResDtos = new ArrayList<>();   // DTO List 생성
        for (Member member : members) memberResDtos.add(convertEntityToDto(member));
        return memberResDtos;
    }*/

    /*// 회원 전체 조회 JDBC
    public List<MemberResDto> findAll() {
        return memberDao.findAll();
    }*/

    // 회원 상세 조회
    public MemberResDto findByEmail(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("해당 회원이 존재하지 않습니다."));   // 500 Error
        return convertEntityToDto(member);
    }

    // 회원 수정
    public boolean modifyMember(String email, MemberReqDto memberReqDto) {
        try {
            Member member = memberRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("해당 회원이 존재하지 않습니다.")); // 500 Error
            member.setName(memberReqDto.getName());
            member.setImage(memberReqDto.getImage());
            memberRepository.save(member);
            return true;
        } catch (Exception e) {
            log.error("회원 정보 수정 실패 : {}", e.getMessage());
            return false;
        }
    }

    // 회원 삭제
    public boolean deleteMember(String email) {
        try {
            Member member = memberRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("해당 회원이 존재하지 않습니다.")); // 500 Error
            memberRepository.delete(member);
            return true;
        } catch (Exception e) {
            log.error("회원 정보 삭제 실패 : {}", e.getMessage());
            return false;
        }
    }

    // Entity -> DTO 메서드
    private MemberResDto convertEntityToDto(Member member) {
        MemberResDto memberResDto = new MemberResDto();
        memberResDto.setEmail(member.getEmail());
        //memberResDto.setPwd(member.getPwd());
        memberResDto.setName(member.getName());
        memberResDto.setImage(member.getImage());
        memberResDto.setRegDate(member.getRegDate());
        return memberResDto;
    }
}
