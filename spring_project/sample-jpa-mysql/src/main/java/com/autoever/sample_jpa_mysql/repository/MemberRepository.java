package com.autoever.sample_jpa_mysql.repository;

import com.autoever.sample_jpa_mysql.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 이메일 존재 여부 확인 : 존재하면 true
    boolean existsByEmail(String email);

    // 이메일로 회원 정보 가져오기, Optional : null 처리하기 위해서 사용
    Optional<Member> findByEmail(String email);

    // 로그인을 성공 실패를 위해 email과 pwd가 존재하는지 확인
    Optional<Member> findByEmailAndPwd(String email, String pwd);
}
