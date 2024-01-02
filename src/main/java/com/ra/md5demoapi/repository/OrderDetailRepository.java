package com.ra.md5demoapi.repository;

import com.ra.md5demoapi.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository  extends JpaRepository<OrderDetail,Long> {
}
