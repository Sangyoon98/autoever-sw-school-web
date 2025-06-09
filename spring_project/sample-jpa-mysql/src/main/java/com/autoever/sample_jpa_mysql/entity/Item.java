package com.autoever.sample_jpa_mysql.entity;

import com.autoever.sample_jpa_mysql.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString   // toString() 오버라이드를 자동으로 해줌
@Entity     // 해당 클래스가 엔티티임을 나타냄, 즉 DB Table로 생성됨
@Table(name = "item")   // 해당 클래스가 DB Table로 생성시 생성될 이름 지정, 소문자로 생성
public class Item {
    @Id     // 기본키 필드 지정, 유일한 값, not null
    @Column(name = "item_id")   // DB로 생성될 컬럼 이름을 지정
    @GeneratedValue(strategy = GenerationType.AUTO) // 기본키 생성 전략, JPA가 DB에 맞게 생성 전략을 결정
    private Long id;    // 상품 코드

    @Column(nullable = false, length = 50)
    private String itemNum; // 상품명

    @Column(name = "price", nullable = false)
    private int price;  // 가격

    @Column(nullable = false)   // stock_number, Snake 표기법으로 자동 변경
    private int stockNumber;    // 재고 수량

    @Lob    // 대용량 문자열 처리
    @Column(nullable = false)
    private String itemDetail;  // 상품 살세 설명

    @Enumerated(EnumType.STRING)    //
    private ItemSellStatus itemSellStatus;  // 상품 판매 상태

    private LocalDateTime regTime;  // 등록 시간
    private LocalDateTime updateTime;   // 수정 시간
}