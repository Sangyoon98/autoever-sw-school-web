package com.autoever.sample_jpa_mysql.service;

import com.autoever.sample_jpa_mysql.document.Product;
import com.autoever.sample_jpa_mysql.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public Product update(String id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }
}