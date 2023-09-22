package com.swigatto.swigatto.service;

import com.swigatto.swigatto.Enum.FoodCategory;
import com.swigatto.swigatto.dto.response.MenuResponse;

import java.util.List;

public interface MenuService {
    List<MenuResponse> getDishesByCategory(FoodCategory foodCategory);

    List<MenuResponse> getDishesByPriceAndRestaurant(double price, int restaurantId);
}
