package com.swigatto.swigatto.service;

import com.swigatto.swigatto.dto.request.FoodRequest;
import com.swigatto.swigatto.dto.response.CartResponse;

public interface CartService {
    CartResponse addToCart(FoodRequest foodRequest);
}
