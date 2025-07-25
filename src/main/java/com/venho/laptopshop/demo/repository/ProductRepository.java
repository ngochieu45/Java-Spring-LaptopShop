package com.venho.laptopshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venho.laptopshop.demo.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
