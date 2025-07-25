package com.venho.laptopshop.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.venho.laptopshop.demo.domain.Product;
import com.venho.laptopshop.demo.repository.ProductRepository;

@Service
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
}
