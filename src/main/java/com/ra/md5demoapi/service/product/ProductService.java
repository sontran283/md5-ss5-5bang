package com.ra.md5demoapi.service.product;

import com.ra.md5demoapi.model.dto.ProductDTO;
import com.ra.md5demoapi.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<ProductDTO> getAll(Pageable pageable);
    Page<ProductDTO> searchByName(Pageable pageable,String name);

    List<ProductDTO> findAll();

    void delete(Long id);

    ProductDTO saveOrUpdate(ProductDTO productDTO);

    ProductDTO findById(Long id);

    Product findProductById(Long id);
}
