package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.request.RestaurantRequest;
import com.swigatto.swigatto.dto.response.FoodResponse;
import com.swigatto.swigatto.dto.response.RestaurantResponse;
import com.swigatto.swigatto.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantTransformer {
    public static Restaurant RestaurantRequestToRestaurant(RestaurantRequest restaurantRequest) {
        return Restaurant.builder()
                .name(restaurantRequest.getName())
                .restaurantCategory(restaurantRequest.getRestaurantCategory())
                .location(restaurantRequest.getLocation())
                .contactNumber(restaurantRequest.getContactNumber())
                .opened(true)
                .availableFoodItems(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }

    public static RestaurantResponse RestaurantToRestaurantResponse(Restaurant restaurant) {
//        List<FoodResponse> menu = new ArrayList<>();
//        if(!restaurant.getAvailableFoodItems().isEmpty()) {
        List<FoodResponse> menu = FoodTransformer.FoodItemsToListOfFoodResponse(restaurant.getAvailableFoodItems());
//        }
        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .location(restaurant.getLocation())
                .contactNumber(restaurant.getContactNumber())
                .menu(menu)
                .build();
    }
}
