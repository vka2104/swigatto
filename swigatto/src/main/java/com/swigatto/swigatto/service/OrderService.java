package com.swigatto.swigatto.service;

import com.swigatto.swigatto.dto.response.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(String mobileNo);
}
