package com.venho.laptopshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venho.laptopshop.demo.domain.Cart;
import com.venho.laptopshop.demo.domain.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);

}
