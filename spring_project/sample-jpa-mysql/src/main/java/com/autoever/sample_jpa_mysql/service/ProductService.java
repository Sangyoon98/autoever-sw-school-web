package com.autoever.sample_jpa_mysql.service;

import com.autoever.sample_jpa_mysql.document.Product;
import com.autoever.sample_jpa_mysql.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final MongoTemplate mongoTemplate;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Product update(String id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public int getTotalQuantity() {
        MatchOperation match = Aggregation.match(Criteria.where("quantity").gte(10));
        GroupOperation group = Aggregation.group().sum("quantity").as("totalQuantity");
        ProjectionOperation project = Aggregation.project("totalQuantity");
        Aggregation aggregation = Aggregation.newAggregation(match, group, project);
        Document result = mongoTemplate.aggregate(aggregation, "products", Document.class)
                .getUniqueMappedResult();

        return result != null ? result.getInteger("totalQuantity", 0) : 0;
    }
}