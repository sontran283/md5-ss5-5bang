package com.ra.md5demoapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String categoryName;
    @Column(columnDefinition = "boolean default true")
    private Boolean status = true;

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private Set<Product> products;

    public Category() {
    }

    public Category(Long id, String categoryName, Boolean status) {
        this.id = id;
        this.categoryName = categoryName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
