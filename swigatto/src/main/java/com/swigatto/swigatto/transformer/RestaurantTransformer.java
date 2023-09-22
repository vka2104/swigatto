package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.request.RestaurantRequest;
import com.swigatto.swigatto.dto.response.MenuResponse;
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
                .availableMenuItems(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }

    public static RestaurantResponse RestaurantToRestaurantResponse(Restaurant restaurant) {
        List<MenuResponse> menu = MenuTransformer.MenuItemsToMenuResponseList(restaurant.getAvailableMenuItems());
        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .location(restaurant.getLocation())
                .contactNumber(restaurant.getContactNumber())
                .menu(menu)
                .build();
    }
}
