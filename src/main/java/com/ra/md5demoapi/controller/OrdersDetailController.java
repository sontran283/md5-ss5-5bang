package com.ra.md5demoapi.controller;

import com.ra.md5demoapi.model.dto.OrderDetailsDTO;
import com.ra.md5demoapi.service.order_details.OrderDetailsService;
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
public class OrdersDetailController {
    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/order_details")
    public ResponseEntity<List<OrderDetailsDTO>> get_list_order_details() {
        List<OrderDetailsDTO> detailsDTOList = orderDetailsService.findAll();
        return new ResponseEntity<>(detailsDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/order_details/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (orderDetailsService.findById(id) != null) {
            orderDetailsService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/order_details")
    public ResponseEntity<?> create_order_details(@RequestBody OrderDetailsDTO orderDetailsDTO) {
        OrderDetailsDTO newDetails = orderDetailsService.saveOrUpdate(orderDetailsDTO);
        return new ResponseEntity<>(newDetails, HttpStatus.CREATED);
    }

    @GetMapping("/order_details/search+sort+pagination")
    public ResponseEntity<Page<OrderDetailsDTO>> getOrderDetails(@RequestParam(name = "search") Integer id,
                                                                 @RequestParam(name = "sort",defaultValue = "id") String sort,
                                                                 @RequestParam(name = "order",defaultValue = "asc") String order,
                                                                 @RequestParam(name = "page",defaultValue = "0") int page,
                                                                 @RequestParam(name="size",defaultValue = "3") int size){
        Pageable pageable;
        if (order.equals("asc")){
            pageable= PageRequest.of(page,size, Sort.by(sort).ascending());
        }else {
            pageable= PageRequest.of(page,size, Sort.by(sort).descending());
        }
        Page<OrderDetailsDTO> orderDetailsDTOS= orderDetailsService.searchByOrderDetailsId(pageable,id);
        return new ResponseEntity<>(orderDetailsDTOS,HttpStatus.OK);
    }
}
