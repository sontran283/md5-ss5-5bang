package com.ra.md5demoapi.service.orders;

import com.ra.md5demoapi.model.dto.OrdersDTO;
import com.ra.md5demoapi.model.entity.Orders;
import com.ra.md5demoapi.model.entity.User;
import com.ra.md5demoapi.repository.OrdersRepository;
import com.ra.md5demoapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<OrdersDTO> findAll() {
        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        List<Orders> ordersList = ordersRepository.findAll();
        for (Orders or : ordersList) {
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.setId(or.getId());
            ordersDTO.setAddress(or.getAddress());
            ordersDTO.setNote(or.getNote());
            ordersDTO.setPhone(or.getPhone());
            ordersDTO.setTotal(or.getTotal());
            ordersDTO.setUserId(or.getUser().getId());
            ordersDTO.setOrderDetails(or.getOrderDetails());
            ordersDTO.setStatus(or.getStatus());
            ordersDTOList.add(ordersDTO);
        }
        return ordersDTOList;
    }

    @Override
    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public OrdersDTO findById(Long id) {
        Optional<Orders> ordersOptional = ordersRepository.findById(id);
        if (ordersOptional.isPresent()) {
            Orders orders = ordersOptional.get();
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.setId(orders.getId());
            ordersDTO.setAddress(orders.getAddress());
            ordersDTO.setNote(orders.getNote());
            ordersDTO.setPhone(orders.getPhone());
            ordersDTO.setTotal(orders.getTotal());
            ordersDTO.setUserId(orders.getUser().getId());
            ordersDTO.setOrderDetails(orders.getOrderDetails());
            ordersDTO.setStatus(orders.getStatus());
            return ordersDTO;
        }
        return null;
    }

    @Override
    public Orders findOrdersById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    @Override
    public OrdersDTO saveOrUpdate(OrdersDTO ordersDTO) {
        Orders orders = new Orders();
        orders.setId(ordersDTO.getId());
        orders.setAddress(ordersDTO.getAddress());
        orders.setNote(ordersDTO.getNote());
        orders.setPhone(ordersDTO.getPhone());
        orders.setTotal(ordersDTO.getTotal());
        orders.setStatus(ordersDTO.getStatus());
        User user = userService.findById(ordersDTO.getUserId());
        orders.setUser(user);
        orders = ordersRepository.save(orders);
        OrdersDTO saveOrdersDTO = new OrdersDTO();
        saveOrdersDTO.setStatus(orders.getStatus());
        return saveOrdersDTO;
    }
}
