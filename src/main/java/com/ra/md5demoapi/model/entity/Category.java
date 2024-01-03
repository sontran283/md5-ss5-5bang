package com.ra.md5demoapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Category {
    @Id // đánh dấu rằng trường id của đối tượng này là trường đại diện cho khóa chính trong cơ sở dữ liệu.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng dần
    private Long id;
    @Column(unique = true) // giá trị của cột này phải là duy nhất (không được trùng lặp).
    private String categoryName;
    @Column(columnDefinition = "boolean default true") // xác định thuộc tính, là một cột kiểu boolean với giá trị mặc định là true
    private Boolean status = true;

    // mappedBy = "category" ___ chỉ định trường nào trong đối tượng Product sẽ quản lý mối quan hệ
    // cascade = CascadeType.REMOVE ___ nghĩa là khi đối tượng Category bị xóa, tất cả các sản phẩm liên quan cũng sẽ bị xóa.
    // fetch = FetchType.LAZY ___ chỉ định cách dữ liệu liên quan (trong trường hợp này là danh sách các sản phẩm) sẽ được tải vào bộ nhớ (lazy loading, tải khi cần).
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
