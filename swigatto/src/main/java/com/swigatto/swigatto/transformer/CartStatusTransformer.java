package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.response.CartResponse;
import com.swigatto.swigatto.dto.response.FoodResponse;
import com.swigatto.swigatto.model.Cart;
import com.swigatto.swigatto.model.FoodItem;

import java.util.List;

public class CartStatusTransformer {
//    public static Cart CartRequestToCartResponse(Cart)
//    public static CartResponse CartToCartResponse(Cart cart) {
////        List<MenuResponse> menuResponseList = MenuTransformer.MenuItemsToMenuResponseList(cart.getFoodItems());
////        return CartResponse.builder()
////                .cartTotal(cart.getCartTotal())
////                .foodItems(menuResponseList)
////                .build();
//    }

    public static CartResponse cartToCartResponse(Cart cart) {
        List<FoodResponse> foodResponseList = FoodTransformer.FoodItemsToListOfFoodResponse(cart.getFoodItems());
        double cartTotal = 0;
        for(FoodItem food: cart.getFoodItems()) {
            cartTotal += food.getRequiredQuantity()*food.getMenuItem().getPrice();
        }
        return CartResponse.builder()
                .customerName(cart.getCustomer().getName())
                .customerMobile(cart.getCustomer().getMobileNo())
                .customerAddress(cart.getCustomer().getAddress())
                .cartTotal(cartTotal)
                .foodList(foodResponseList)
                .restaurantName(cart.getFoodItems().get(0).getMenuItem().getRestaurant().getName())
                .build();
    }
}
