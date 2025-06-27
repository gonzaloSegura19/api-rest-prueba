package com.mx.api_rest_prueba.repository;

import com.mx.api_rest_prueba.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByCategory(String category);
}