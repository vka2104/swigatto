package com.swigatto.swigatto.service.impl;

import com.swigatto.swigatto.Enum.FoodCategory;
import com.swigatto.swigatto.dto.response.MenuResponse;
import com.swigatto.swigatto.exception.FoodNotAvailableException;
import com.swigatto.swigatto.exception.RestaurantNotFoundException;
import com.swigatto.swigatto.model.MenuItem;
import com.swigatto.swigatto.repositary.MenuRepositary;
import com.swigatto.swigatto.service.MenuService;
import com.swigatto.swigatto.transformer.FoodTransformer;
import com.swigatto.swigatto.transformer.MenuTransformer;
import com.swigatto.swigatto.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuImpl implements MenuService {
    final MenuRepositary menuRepositary;
    final ValidationUtil validationUtil;
    @Autowired
    public MenuImpl(MenuRepositary menuRepositary, ValidationUtil validationUtil) {
        this.menuRepositary = menuRepositary;
        this.validationUtil = validationUtil;
    }

    public List<MenuResponse> getDishesByCategory(FoodCategory foodCategory) {
        List<MenuItem> menuItems = menuRepositary.findByFoodCategory(foodCategory);
        if(menuItems.isEmpty()) throw new FoodNotAvailableException("There is no food available in the given category !!");
        return MenuTransformer.MenuItemsToMenuResponseList(menuItems);
    }
    public List<MenuResponse> getDishesByPriceAndRestaurant(double price, int restaurantId) {
        if(validationUtil.ValidateRestaurantExist(restaurantId) == null) throw new RestaurantNotFoundException("There is no restaurant Exist!");
        List<MenuItem> menuItems = menuRepositary.getFoodsByPriceAndRestaurantHQL(price, restaurantId);
        if(menuItems.isEmpty()) throw new FoodNotAvailableException("There is no food available !!");
        return MenuTransformer.MenuItemsToMenuResponseList(menuItems);
    }


}
