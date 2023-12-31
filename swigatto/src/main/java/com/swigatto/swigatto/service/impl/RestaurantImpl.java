package com.swigatto.swigatto.service.impl;

import com.swigatto.swigatto.dto.request.MenuRequest;
import com.swigatto.swigatto.dto.request.RestaurantRequest;
import com.swigatto.swigatto.dto.response.MenuResponse;
import com.swigatto.swigatto.dto.response.RestaurantResponse;
import com.swigatto.swigatto.exception.RestaurantNotFoundException;
import com.swigatto.swigatto.model.MenuItem;
import com.swigatto.swigatto.model.Restaurant;
import com.swigatto.swigatto.repositary.RestaurantRepositary;
import com.swigatto.swigatto.service.RestaurantService;
import com.swigatto.swigatto.transformer.FoodTransformer;
import com.swigatto.swigatto.transformer.MenuTransformer;
import com.swigatto.swigatto.transformer.RestaurantTransformer;
import com.swigatto.swigatto.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantImpl implements RestaurantService {
    final RestaurantRepositary restaurantRepositary;
    final ValidationUtil validationUtil;
    @Autowired
    public RestaurantImpl(RestaurantRepositary restaurantRepositary, ValidationUtil validationUtil) {
        this.restaurantRepositary = restaurantRepositary;
        this.validationUtil = validationUtil;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = RestaurantTransformer.RestaurantRequestToRestaurant(restaurantRequest);
        Restaurant savedRestaurant = restaurantRepositary.save(restaurant);
       return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);
    }
    public String changeOpenedStatus(int id) {
       Optional<Restaurant> restaurantOpt = restaurantRepositary.findById(id);
       if(restaurantOpt.isEmpty()) throw new RestaurantNotFoundException("Restaurant not exist!");
       Restaurant restaurant = restaurantOpt.get();
       restaurant.setOpened(!restaurant.isOpened());
       Restaurant savedRestaurant = restaurantRepositary.save(restaurant);
       if(savedRestaurant.isOpened()) return "Restaurant is Opened Now !!";
       else return "Restaurant is Closed";
    }

    public  RestaurantResponse addFoodToRestaurantMenu(MenuRequest menuRequest) {
        Restaurant restaurant = validationUtil.ValidateRestaurantExist(menuRequest.getRestaurantId());
        if(restaurant == null) throw new RestaurantNotFoundException("Restaurant not exist!");

        MenuItem menuItem = MenuTransformer.MenuRequestToMenuItem(menuRequest);
        //food is a child many menu items can contain restaurant.so we need to add restaurant id to each menu item
        menuItem.setRestaurant(restaurant);

        restaurant.getAvailableMenuItems().add(menuItem);

        Restaurant savedRestaurant = restaurantRepositary.save(restaurant);
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);

    }
    public List<MenuResponse> getMenuByRestaurantId(int id) {
        Restaurant restaurant = validationUtil.ValidateRestaurantExist(id);
        if(restaurant == null) throw new RestaurantNotFoundException("Restaurant not exist!");
        return MenuTransformer.MenuItemsToMenuResponseList(restaurant.getAvailableMenuItems());
    }

}
