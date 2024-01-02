package com.ra.md5demoapi.controller;

import com.ra.md5demoapi.model.dto.ProductDTO;
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

    //    lay list
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> get_list_products() {
        List<ProductDTO> productDTOList = productService.findAll();
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

    //    them moi
    @PostMapping("/products")
    public ResponseEntity<ProductDTO> create_product(@RequestBody ProductDTO productDTO) {
        ProductDTO newPro = productService.saveOrUpdate(productDTO);
        return new ResponseEntity<>(newPro, HttpStatus.CREATED);
    }

    //    xoa
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (productService.findById(id) != null) {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    //    chinh sua
    @GetMapping("products/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Long id) {
        ProductDTO idEdit = productService.findById(id);
        if (idEdit != null) {
            return new ResponseEntity<>(idEdit, HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
        ProductDTO productDTO1 = productService.findById(id);
        productDTO1.setProductName(productDTO.getProductName());
        productDTO1.setStatus(productDTO.getStatus());
        productDTO1.setCategoryId(productDTO.getCategoryId());
        ProductDTO newPro = productService.saveOrUpdate(productDTO1);
        return new ResponseEntity<>(newPro, HttpStatus.OK);
    }


    //    sort + search + pagination
//    @GetMapping("/products/search")
//    public ResponseEntity<Page<ProductDTO>> searchProducts(@RequestParam(name = "search") String search,
//                                                           @RequestParam(name = "page", defaultValue = "0") int page,
//                                                           @RequestParam(name = "size", defaultValue = "10") int size,
//                                                           @RequestParam(name = "sort",defaultValue = "id") String sort,
//                                                           @RequestParam(name = "order",defaultValue = "asc") String order) {
//        Pageable pageable ;
//        if (order.equals("asc")){
//            pageable=PageRequest.of(page, size, Sort.by(sort).ascending());
//        }else {
//            pageable=PageRequest.of(page, size, Sort.by(sort).descending());
//
//        }
//        Page<ProductDTO> productDTOS=productService.searchByName(pageable,search);
//        return new ResponseEntity<>(productDTOS,HttpStatus.OK);
//    }


    //    sort + pagination
//    @GetMapping("/products/pagination")
//    public ResponseEntity<Page<ProductDTO>> getPaginatedProducts(@RequestParam(name = "page", defaultValue = "0") int page,
//                                                                 @RequestParam(name = "size", defaultValue = "10") int size,
//                                                                 @RequestParam(name = "sort",defaultValue = "id") String sort,
//                                                                 @RequestParam(name = "order",defaultValue = "asc") String order) {
//        Pageable pageable ;
//        if (order.equals("asc")){
//            pageable=PageRequest.of(page, size, Sort.by(sort).ascending());
//        }else {
//            pageable=PageRequest.of(page, size, Sort.by(sort).descending());
//
//        }
//        Page<ProductDTO> productDTOPage=productService.getAll(pageable);
//        return new ResponseEntity<>(productDTOPage, HttpStatus.OK);
//    }
}
