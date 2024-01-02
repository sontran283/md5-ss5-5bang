package com.ra.md5demoapi.repository;

import com.ra.md5demoapi.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoy extends JpaRepository<Product, Integer> {
}
