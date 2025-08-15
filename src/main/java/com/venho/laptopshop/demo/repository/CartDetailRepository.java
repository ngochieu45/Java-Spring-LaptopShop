package com.venho.laptopshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venho.laptopshop.demo.domain.CartDetail;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

}
