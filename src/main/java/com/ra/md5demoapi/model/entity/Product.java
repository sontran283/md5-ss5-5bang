package com.ra.md5demoapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    @Column(columnDefinition = "Boolean default true")
    private Boolean status = true;
    @ManyToOne
    @JoinColumn(name = "catId", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetail;

    public Product() {
    }

    public Product(Long id, String productName, Boolean status, Category category, Set<OrderDetail> orderDetail) {
        this.id = id;
        this.productName = productName;
        this.status = status;
        this.category = category;
        this.orderDetail = orderDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Set<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
