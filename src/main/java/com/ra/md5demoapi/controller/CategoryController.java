package com.ra.md5demoapi.controller;

import com.ra.md5demoapi.model.entity.Category;
import com.ra.md5demoapi.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> category() {
        List<Category> list = categoryService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        Category newCategory = categoryService.save(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category categoryUpdate = categoryService.findById(id);
        categoryUpdate.setCategoryName(category.getCategoryName());
        categoryUpdate.setStatus(category.isStatus());

        Category newCategory = categoryService.save(categoryUpdate);
        return new ResponseEntity<>(newCategory, HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
