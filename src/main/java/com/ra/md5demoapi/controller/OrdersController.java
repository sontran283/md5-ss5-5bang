package com.ra.md5demoapi.controller;

import com.ra.md5demoapi.model.dto.OrdersDTO;
import com.ra.md5demoapi.service.orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrdersDTO>> get_list_orders() {
        List<OrdersDTO> ordersDTOList = ordersService.findAll();
        return new ResponseEntity<>(ordersDTOList, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<OrdersDTO> create_orders(@RequestBody OrdersDTO ordersDTO) {
        OrdersDTO newOrders = ordersService.saveOrUpdate(ordersDTO);
        return new ResponseEntity<>(newOrders, HttpStatus.CREATED);
    }

    @DeleteMapping("/orders/{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") Long id){
        if (ordersService.findById(id) !=null){
            ordersService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Long id){
        OrdersDTO idEdit=ordersService.findById(id);
        if (idEdit!=null){
            return new ResponseEntity<>(idEdit,HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
    }
    @PatchMapping("/orders/{id}")
    public ResponseEntity<?> change_status(@PathVariable("id") Long id, @RequestBody OrdersDTO ordersDTO) {
        OrdersDTO ordersDTO1 = ordersService.findById(id);
        if (ordersDTO1 != null) {
            if (ordersDTO.getStatus() == 0) {
                ordersDTO1.setStatus(0);
                ordersService.saveOrUpdate(ordersDTO1);
                return new ResponseEntity<>("Accepted", HttpStatus.ACCEPTED);
            } else if (ordersDTO.getStatus() == 2) {
                ordersDTO1.setStatus(2);
                ordersService.saveOrUpdate(ordersDTO1);
                return new ResponseEntity<>("Denied", HttpStatus.NOT_ACCEPTABLE);
            }
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/orders/search+sort+pagination")
    public ResponseEntity<Page<OrdersDTO>> getOrders(@RequestParam(name = "search") Integer id,
                                                     @RequestParam(name = "sort",defaultValue = "id") String sort,
                                                     @RequestParam(name = "order",defaultValue = "asc") String order,
                                                     @RequestParam(name = "page",defaultValue = "0") int page,
                                                     @RequestParam(name = "size",defaultValue = "3") int size){
        Pageable pageable;
        if (order.equals("asc")){
            pageable= PageRequest.of(page,size, Sort.by(sort).ascending());
        }else {
            pageable= PageRequest.of(page,size, Sort.by(sort).descending());
        }
        Page<OrdersDTO> ordersDTOPage=ordersService.searchOrdersById(pageable,id);
        return new ResponseEntity<>(ordersDTOPage,HttpStatus.OK);
    }
}
