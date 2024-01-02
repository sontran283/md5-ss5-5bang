package com.ra.md5demoapi.model.dto;

import com.ra.md5demoapi.model.entity.OrderDetail;

import java.util.Set;

public class OrdersDTO {
    private Long id;
    private String address;
    private String phone;
    private String note;
    private float total;
    private int status=1;
    private Long userId;
    private Set<OrderDetail> orderDetails;

    public OrdersDTO() {
    }

    public OrdersDTO(Long id, String address, String phone, String note, float total, int status, Long userId, Set<OrderDetail> orderDetails) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.total = total;
        this.status = status;
        this.userId = userId;
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
