package com.venho.laptopshop.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.venho.laptopshop.demo.domain.Product;
import com.venho.laptopshop.demo.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product handleSaveProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    public Product getProductById(long id) {
        return this.productRepository.findById(id);
    }
}
