package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.response.CartResponse;
import com.swigatto.swigatto.dto.response.FoodResponse;
import com.swigatto.swigatto.model.Cart;

import java.util.List;

public class CartTransformer {
//    public static Cart CartRequestToCartResponse(Cart)
    public static CartResponse CartToCartResponse(Cart cart) {
        List<FoodResponse> foodResponseList = FoodTransformer.FoodItemsToListOfFoodResponse(cart.getFoodItemList());
        return CartResponse.builder()
                .cartTotal(cart.getCartTotal())
                .foodItems(foodResponseList)
                .build();
    }
}
