package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.request.MenuRequest;
import com.swigatto.swigatto.dto.response.MenuResponse;
import com.swigatto.swigatto.model.FoodItem;
import com.swigatto.swigatto.model.MenuItem;

import java.util.List;

public class FoodTransformer {

    public static MenuItem FoodRequestToFoodItem(MenuRequest menuRequest) {
        return MenuItem.builder()
                .dishName(menuRequest.getDishName())
                .foodCategory(menuRequest.getFoodCategory())
                .price(menuRequest.getPrice())
                .available(menuRequest.isAvailable())
                .veg(menuRequest.isVeg())
                .build();
    }
    public static MenuResponse FoodItemToFoodResponse(FoodItem foodItem) {
        return MenuResponse.builder()
                .dishName(foodItem.getMenuItem().getDishName())
                .price(foodItem.getMenuItem().getPrice())
                .veg(foodItem.getMenuItem().isVeg())
                .foodCategory(foodItem.getMenuItem().getFoodCategory())
                .build();
    }
    public static List<MenuResponse> FoodItemsToListOfFoodResponse(List<FoodItem> foodItems) {
        //map(foodItem -> FoodItemToFoodResponse(foodItems)) we're doing this below
        return foodItems.stream().map(FoodTransformer::FoodItemToFoodResponse).toList();
    }
}
