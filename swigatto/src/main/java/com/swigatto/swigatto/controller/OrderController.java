package com.swigatto.swigatto.controller;

import com.swigatto.swigatto.dto.response.CustomerResponse;
import com.swigatto.swigatto.dto.response.OrderResponse;
import com.swigatto.swigatto.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    final OrderService orderService;
    @Autowired
    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place/mobile/{mobileNo}")
    public ResponseEntity placeOrder(@PathVariable String mobileNo) {
        try {
            OrderResponse orderResponse = orderService.placeOrder(mobileNo);
            return ResponseEntity.status(HttpStatus.FOUND).body(orderResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
