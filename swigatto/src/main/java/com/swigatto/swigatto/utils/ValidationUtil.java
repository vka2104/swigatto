package com.swigatto.swigatto.utils;

import com.swigatto.swigatto.exception.RestaurantNotFoundException;
import com.swigatto.swigatto.model.Restaurant;
import com.swigatto.swigatto.repositary.RestaurantRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidationUtil {
    final RestaurantRepositary restaurantRepositary;

    @Autowired
    public ValidationUtil(RestaurantRepositary restaurantRepositary) {
        this.restaurantRepositary = restaurantRepositary;
    }

    public Restaurant ValidateRestaurantExist(int id) {
        Optional<Restaurant> restaurantOpt = restaurantRepositary.findById(id);
        return restaurantOpt.orElse(null);
    }
}
