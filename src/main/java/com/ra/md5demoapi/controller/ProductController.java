package com.ra.md5demoapi.controller;

import com.ra.md5demoapi.model.entity.Category;
import com.ra.md5demoapi.model.entity.Product;
import com.ra.md5demoapi.service.category.CategoryService;
import com.ra.md5demoapi.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> productList = productService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productService.save(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        try {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
