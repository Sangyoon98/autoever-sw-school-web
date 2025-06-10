package com.autoever.sample_jpa_mysql.repository;

import com.autoever.sample_jpa_mysql.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // 기본적인 CRUD가 포함되어 있음
}
