package com.ra.md5demoapi.repository;

import com.ra.md5demoapi.model.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository  extends JpaRepository<Orders,Long> {
    Page<Orders> findOrdersById(Pageable pageable, Integer id);
}
