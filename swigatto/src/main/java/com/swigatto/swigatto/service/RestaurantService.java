package com.swigatto.swigatto.service;

import com.swigatto.swigatto.dto.request.MenuRequest;
import com.swigatto.swigatto.dto.request.RestaurantRequest;
import com.swigatto.swigatto.dto.response.MenuResponse;
import com.swigatto.swigatto.dto.response.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest);

    String changeOpenedStatus(int id);

    RestaurantResponse addFoodToRestaurantMenu(MenuRequest menuRequest);

    List<MenuResponse> getMenuByRestaurantId(int id);
}
