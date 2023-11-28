package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.request.FoodRequest;
import com.swigatto.swigatto.dto.request.MenuRequest;
import com.swigatto.swigatto.dto.response.FoodResponse;
import com.swigatto.swigatto.dto.response.MenuResponse;
import com.swigatto.swigatto.model.FoodItem;
import com.swigatto.swigatto.model.MenuItem;

import java.util.List;

public class FoodTransformer {

    public static FoodItem FoodRequestToFoodItem(FoodRequest foodRequest, MenuItem menuItem) {
        return FoodItem.builder()
                .menuItem(menuItem)
                .requiredQuantity(foodRequest.getRequiredQuantity())
                .totalCost(foodRequest.getRequiredQuantity()* menuItem.getPrice())
                .build();
    }
    public static FoodResponse FoodItemToFoodResponse(FoodItem foodItem) {
        return FoodResponse.builder()
                .dishName(foodItem.getMenuItem().getDishName())
                .price(foodItem.getMenuItem().getPrice())
                .veg(foodItem.getMenuItem().isVeg())
                .category(foodItem.getMenuItem().getFoodCategory())
                .quantityAdded(foodItem.getRequiredQuantity())
                .build();
    }
    public static List<FoodResponse> FoodItemsToListOfFoodResponse(List<FoodItem> foodItems) {
        //map(foodItem -> FoodItemToFoodResponse(foodItems)) we're doing this below
        return foodItems.stream().map(FoodTransformer::FoodItemToFoodResponse).toList();
    }
}
