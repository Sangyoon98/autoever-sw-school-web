package com.autoever.sample_jpa_mysql.controller;

import com.autoever.sample_jpa_mysql.document.Product;
import com.autoever.sample_jpa_mysql.repository.ProductRepository;
import com.autoever.sample_jpa_mysql.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor  // 생성자 주입 (Lombok)
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    // ✅ 전체 상품 조회
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    // ✅ 상품 등록
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product saved = productRepository.save(product);
        return ResponseEntity.status(201).body(saved);
    }

    // ✅ 이름으로 상품 조회
    @GetMapping("/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable String name) {
        Optional<Product> optional = productRepository.findByName(name);
        return optional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ 상품 수정
    @PutMapping("/{name}")
    public ResponseEntity<?> updateProduct(@PathVariable String name, @RequestBody Product updated) {
        Optional<Product> optional = productRepository.findByName(name);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Product existing = optional.get();
        existing.setPrice(updated.getPrice());
        existing.setQuantity(updated.getQuantity());
        return ResponseEntity.ok(productRepository.save(existing));
    }

    // ✅ 상품 삭제
    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteProduct(@PathVariable String name) {
        Optional<Product> optional = productRepository.findByName(name);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        productRepository.delete(optional.get());
        return ResponseEntity.ok().build();
    }

    // ✅ Aggregation API: 재고 수량이 10개 이상인 상품 총합
    @GetMapping("/summary")
    public ResponseEntity<?> getTotalQuantity() {
        int total = productService.getTotalQuantity();
        return ResponseEntity.ok().body(
                new Object() {
                    public final int totalQuantity = total;
                }
        );
    }
}