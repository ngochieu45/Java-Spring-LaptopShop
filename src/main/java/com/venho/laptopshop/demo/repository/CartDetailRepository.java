package com.venho.laptopshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venho.laptopshop.demo.domain.Cart;
import com.venho.laptopshop.demo.domain.CartDetail;
import com.venho.laptopshop.demo.domain.Product;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    CartDetail findByCartAndProduct(Cart cart, Product product);
}
