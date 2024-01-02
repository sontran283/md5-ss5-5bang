package com.ra.md5demoapi.repository;

import com.ra.md5demoapi.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
