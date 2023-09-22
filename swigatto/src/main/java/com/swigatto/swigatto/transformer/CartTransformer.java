package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.response.CartResponse;
import com.swigatto.swigatto.dto.response.MenuResponse;
import com.swigatto.swigatto.model.Cart;

import java.util.List;

public class CartTransformer {
//    public static Cart CartRequestToCartResponse(Cart)
    public static CartResponse CartToCartResponse(Cart cart) {
        List<MenuResponse> menuResponseList = FoodTransformer.FoodItemsToListOfFoodResponse(cart.getFoodItems());
        return CartResponse.builder()
                .cartTotal(cart.getCartTotal())
                .foodItems(menuResponseList)
                .build();
    }
}
