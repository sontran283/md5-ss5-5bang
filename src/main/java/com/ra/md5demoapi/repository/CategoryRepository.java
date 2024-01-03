package com.ra.md5demoapi.repository;

import com.ra.md5demoapi.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findAllByCategoryNameContainingIgnoreCase(Pageable pageable, String name);
}