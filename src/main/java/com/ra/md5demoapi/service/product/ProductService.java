package com.ra.md5demoapi.service.product;

import com.ra.md5demoapi.model.dto.ProductDTO;
import com.ra.md5demoapi.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAll();

    void delete(Long id);

    ProductDTO saveOrUpdate(ProductDTO productDTO);

    ProductDTO findById(Long id);

    Product findProductById(Long id);
}
