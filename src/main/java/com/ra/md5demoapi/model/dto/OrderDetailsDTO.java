package com.ra.md5demoapi.model.dto;

public class OrderDetailsDTO {
    private Long id;
    private float price;
    private int quantity;

    private Long productId;

    private Long ordersId;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(Long id, float price, int quantity, Long productId, Long ordersId) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.productId = productId;
        this.ordersId = ordersId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }
}
