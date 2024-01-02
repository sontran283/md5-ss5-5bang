package com.ra.md5demoapi.model.dto;

import com.ra.md5demoapi.model.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProductDTO {
    private int id;

    private String productName;

    private boolean status;

    private Long categoryId;

    public ProductDTO() {

    }

    public ProductDTO(int id, String productName, boolean status, Long categoryId) {
        this.id = id;
        this.productName = productName;
        this.status = status;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
