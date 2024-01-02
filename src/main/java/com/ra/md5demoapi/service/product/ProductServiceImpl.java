package com.ra.md5demoapi.service.product;

import com.ra.md5demoapi.model.dto.ProductDTO;
import com.ra.md5demoapi.model.entity.Category;
import com.ra.md5demoapi.model.entity.Product;
import com.ra.md5demoapi.repository.ProductRepositoy;
import com.ra.md5demoapi.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepositoy productRepositoy;
    @Autowired
    private CategoryService categoryService;

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepositoy.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product pro : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(pro.getId());
            productDTO.setProductName(pro.getProductName());
            productDTO.setStatus(pro.getStatus());
            productDTO.setCategoryId(pro.getCategory().getId());
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public void delete(Long id) {
        productRepositoy.deleteById(id);
    }

    @Override
    public ProductDTO saveOrUpdate(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setStatus(productDTO.getStatus());
        Category cat = categoryService.findById(productDTO.getCategoryId());
        product.setCategory(cat);
        product = productRepositoy.save(product);
        ProductDTO saveProductDTO = new ProductDTO();
        saveProductDTO.setId(product.getId());
        saveProductDTO.setProductName(product.getProductName());
        saveProductDTO.setStatus(product.getStatus());
        saveProductDTO.setCategoryId(product.getCategory().getId());
        return saveProductDTO;
    }

    @Override
    public ProductDTO findById(Long id) {
        Optional<Product> productOptional = productRepositoy.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setProductName(product.getProductName());
            productDTO.setStatus(product.getStatus());
            productDTO.setCategoryId(product.getCategory().getId());
            return productDTO;
        } else {
            return null;
        }
    }

    @Override
    public Product findProductById(Long id) {
        return productRepositoy.findById(id).orElse(null);
    }
}
