package com.ra.md5demoapi.service.order_details;

import com.ra.md5demoapi.model.dto.OrderDetailsDTO;

import java.util.List;

public interface OrderDetailsService {
    List<OrderDetailsDTO> findAll();
    void delete(Long id);
    OrderDetailsDTO findById(Long id);
    OrderDetailsDTO saveOrUpdate(OrderDetailsDTO orderDetailsDTO);
}
