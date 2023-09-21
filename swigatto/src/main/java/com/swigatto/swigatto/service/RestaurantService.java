package com.swigatto.swigatto.service;

import com.swigatto.swigatto.dto.request.FoodRequest;
import com.swigatto.swigatto.dto.request.RestaurantRequest;
import com.swigatto.swigatto.dto.response.FoodResponse;
import com.swigatto.swigatto.dto.response.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest);

    String changeOpenedStatus(int id);

    RestaurantResponse addFoodToRestaurantMenu(FoodRequest foodRequest);

    List<FoodResponse> getMenuByRestaurantId(int id);
}
