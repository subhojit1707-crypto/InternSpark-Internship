package com.example.Product_api.service;

import com.example.Product_api.dto.ProductDTO;
import com.example.Product_api.model.Product;
import com.example.Product_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    // Dependency Injection via constructor
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Product createProduct(ProductDTO dto) {
        Product product = new Product(dto.getName(), dto.getDescription(), dto.getPrice());
        return repository.save(product);
    }

    // READ ALL
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // READ ONE
    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    // UPDATE
    public Optional<Product> updateProduct(Long id, ProductDTO dto) {
        return repository.findById(id).map(existingProduct -> {
            existingProduct.setName(dto.getName());
            existingProduct.setDescription(dto.getDescription());
            existingProduct.setPrice(dto.getPrice());
            return repository.save(existingProduct);
        });
    }

    // DELETE
    public boolean deleteProduct(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}