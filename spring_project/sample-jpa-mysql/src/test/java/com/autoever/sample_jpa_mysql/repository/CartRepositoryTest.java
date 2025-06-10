package com.autoever.sample_jpa_mysql.repository;

import com.autoever.sample_jpa_mysql.entity.Cart;
import com.autoever.sample_jpa_mysql.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Slf4j  // Log 메시지를 출력하기 위해서 사용하는 롬복의 어노테이션
@Transactional  // 여러개의 작업을 한개의 논리적인 작업 단위로 묶어 줌, 테스트 성공 / 실패와 상관 없이 자동 롤백
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class CartRepositoryTest {
    @Autowired  // 의존성 주입을 받음, 생성자를 통한 의존성 주입린 경우는 어노테이션 필요 없음
    CartRepository cartRepository;

    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext // JPA의 Entity Manager
    EntityManager em;

    // 회원 엔티티 생성
    public Member createMemberInfo() {
        Member member = new Member();
        member.setEmail("qlrqod123123@naver.com");
        member.setName("채상윤");
        member.setPwd("qwer1234!");
        member.setRegDate(LocalDateTime.now());
        return member;
    }

    @Test
    @DisplayName("장바구니 회원 매핑 조회 테스트")
    public void findCartAndMemberTest() {
        Member member = createMemberInfo();
        memberRepository.save(member);  // DB에 회원 추가

        Cart cart = new Cart();
        cart.setCartName("자동차 구매 장바구니");
        cart.setMember(member);
        cartRepository.save(cart);

        em.flush(); // 영속성 컨텍스트에 저장된 내용을 DB에 반영
        em.clear(); // 영속성 컨텍스트 메모리 비움

        Cart saveCart = cartRepository.findById(cart.getId()).orElseThrow(EntityNotFoundException::new);
        log.info("Cart : {}", saveCart);
    }
}