package com.mrj.dao;

import com.mrj.domain.Product;
import com.mrj.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
