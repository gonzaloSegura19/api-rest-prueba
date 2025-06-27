package com.mx.api_rest_prueba.service;

import com.mx.api_rest_prueba.model.Product;
import com.mx.api_rest_prueba.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product create(Product product) {
        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> findById(String id) {
        return repository.findById(id);
    }

    public Product update(String id, Product updatedProduct) {
        Product product = repository.findById(id).orElseThrow();
        product.setName(updatedProduct.getName());
        product.setCategory(updatedProduct.getCategory());
        product.setQuantity(updatedProduct.getQuantity());
        product.setPrice(updatedProduct.getPrice());
        return repository.save(product);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> findByCategory(String category) {
        return repository.findByCategory(category);
    }
}
