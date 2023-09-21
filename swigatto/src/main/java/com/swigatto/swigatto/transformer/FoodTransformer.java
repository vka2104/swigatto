package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.request.FoodRequest;
import com.swigatto.swigatto.dto.response.FoodResponse;
import com.swigatto.swigatto.model.FoodItem;

import java.util.List;

public class FoodTransformer {

    public static FoodItem FoodRequestToFoodItem(FoodRequest foodRequest) {
        return FoodItem.builder()
                .dishName(foodRequest.getDishName())
                .foodCategory(foodRequest.getFoodCategory())
                .price(foodRequest.getPrice())
                .available(foodRequest.isAvailable())
                .veg(foodRequest.isVeg())
                .build();
    }
    public static FoodResponse FoodItemToFoodResponse(FoodItem foodItem) {
        return FoodResponse.builder()
                .dishName(foodItem.getDishName())
                .price(foodItem.getPrice())
                .veg(foodItem.isVeg())
                .foodCategory(foodItem.getFoodCategory())
                .build();
    }
    public static List<FoodResponse> FoodItemsToListOfFoodResponse(List<FoodItem> foodItems) {
        //map(foodItem -> FoodItemToFoodResponse(foodItems)) we're doing this below
        return foodItems.stream().map(FoodTransformer::FoodItemToFoodResponse).toList();
    }
}
