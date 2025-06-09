package com.autoever.sample_jpa_mysql.repository;

import com.autoever.sample_jpa_mysql.constant.ItemSellStatus;
import com.autoever.sample_jpa_mysql.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j  // Log 메시지를 출력하기 위해서 사용하는 롬복의 어노테이션
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;  // 필드 의존성 주입을 받음

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        Item item = new Item();
        item.setItemNum("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        Item savedItem = itemRepository.save(item);
        log.debug("item : {}", savedItem);
    }

    public void createItemList() {
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemNum("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item); // 새로운 아이템 추가, INSERT, UPDATE
            log.info("item : {}", savedItem);
        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNumTest() {
        this.createItemList();
        List<Item> list = itemRepository.findByItemNum("테스트 상품5");
        for (Item item : list) {
            log.info("Item : {}", item);
        }
    }

    @Test
    @DisplayName("상품명 or 상품 상세 설명")
    public void findByItemOrItemDetailTest() {
        this.createItemList();
        List<Item> list = itemRepository.findByItemNumOrItemDetail("테스트 상품1", "테스트 상품 상세 설명5");
        for (Item item : list) {
            log.info("Item : {}", item);
        }
    }

    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    public void findByItemDetailTest() {
        this.createItemList();
        List<Item> list = itemRepository.findByItemDetail("테스트 상품 상세 설명5");
        for (Item item : list) {
            log.info("Item : {}", item);
        }
    }

    @Test
    @DisplayName("nativeQuery를 이용한 상품 조회 테스트")
    public void findByItemDetailByNative() {
        this.createItemList();
        List<Item> list = itemRepository.findByItemDetailByNative("테스트 상품 상세 설명8");
        for (Item item : list) {
            log.info("Item : {}", item);
        }
    }
}