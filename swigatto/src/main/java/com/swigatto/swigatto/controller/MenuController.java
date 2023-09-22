package com.swigatto.swigatto.controller;

import com.swigatto.swigatto.Enum.FoodCategory;
import com.swigatto.swigatto.dto.response.MenuResponse;
import com.swigatto.swigatto.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    final MenuService menuService;
    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // get all foods of a particualr category
    @GetMapping("/category")
    public ResponseEntity getDishesByCategory(@RequestParam FoodCategory foodCategory) {
        try {
            List<MenuResponse> foodList = menuService.getDishesByCategory(foodCategory);
            return ResponseEntity.status(HttpStatus.FOUND).body(foodList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    // get all MAIN_COURSE items with price above x rupees from a particular restaurant.
    @GetMapping("/mainCourse")
    public ResponseEntity getDishesByPriceAndRestaurant(@RequestParam double price, @RequestParam int restaurantId) {
        try {
            List<MenuResponse> foodList = menuService.getDishesByPriceAndRestaurant(price, restaurantId);
            return ResponseEntity.status(HttpStatus.FOUND).body(foodList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // get all veg foods of a restaurant

    // get all non veg foods of a restaurant

    // Get cheapest 5 food items of a partiuclar restaurant

    // Get costliest 5 food items of a partiuclar restaurant

    // Get costliest 5 food items of a partiuclar catgeory -> name fo dish and rest which serves that dish

}
