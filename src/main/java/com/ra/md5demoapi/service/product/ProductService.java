package com.ra.md5demoapi.service.product;

import com.ra.md5demoapi.model.entity.Category;
import com.ra.md5demoapi.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product save(Product product);

    Product findById(Integer id);

    void delete(Integer id);
}
