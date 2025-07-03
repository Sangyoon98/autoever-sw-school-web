package com.autoever.sample_jpa_mysql.repository;

import com.autoever.sample_jpa_mysql.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByPriceGreaterThan(int price);
    Optional<Product> findByName(String name);
}