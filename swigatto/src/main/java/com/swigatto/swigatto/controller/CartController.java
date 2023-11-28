package com.swigatto.swigatto.controller;

import com.swigatto.swigatto.dto.request.FoodRequest;
import com.swigatto.swigatto.dto.response.CartResponse;
import com.swigatto.swigatto.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
//    @Autowired
//    CartService cartService;
    final CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody FoodRequest foodRequest) {
        try {
            CartResponse cartResponse = cartService.addToCart(foodRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(cartResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
