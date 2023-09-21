package com.swigatto.swigatto.controller;

import com.swigatto.swigatto.dto.request.RestaurantRequest;
import com.swigatto.swigatto.dto.request.FoodRequest;
import com.swigatto.swigatto.dto.response.FoodResponse;
import com.swigatto.swigatto.dto.response.RestaurantResponse;
import com.swigatto.swigatto.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

   final RestaurantService restaurantService;


   @Autowired
    public RestaurantController(RestaurantService restaurantService) {
       this.restaurantService = restaurantService;
    }

    @PostMapping("add")
    public ResponseEntity addRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantResponse);
    }

    @PutMapping("/update/status")
    public ResponseEntity changeOpenedStatus(@RequestParam int id) {
       String res = restaurantService.changeOpenedStatus(id);
       return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    @PostMapping("/add/food")
    public ResponseEntity addFoodToRestaurantMenu(@RequestBody FoodRequest foodRequest) {
       RestaurantResponse restaurantResponse = restaurantService.addFoodToRestaurantMenu(foodRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantResponse);
    }

    @GetMapping("/menu")
    public ResponseEntity getMenuByRestaurantId(@RequestParam int id) {
       List<FoodResponse> menu = restaurantService.getMenuByRestaurantId(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(menu);
    }

}
