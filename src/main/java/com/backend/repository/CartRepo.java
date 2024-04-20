package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.entity.Cart;
import com.backend.entity.Category;

@Repository
public interface CartRepo  extends JpaRepository<Cart, Long> {

}