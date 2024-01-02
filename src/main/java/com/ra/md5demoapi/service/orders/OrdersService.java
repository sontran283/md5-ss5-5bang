package com.ra.md5demoapi.service.orders;

import com.ra.md5demoapi.model.dto.OrdersDTO;
import com.ra.md5demoapi.model.entity.Orders;

import java.util.List;

public interface OrdersService {
    List<OrdersDTO> findAll();

    void delete(Long id);

    OrdersDTO findById(Long id);

    Orders findOrdersById(Long id);

    OrdersDTO saveOrUpdate(OrdersDTO ordersDTO);
}
