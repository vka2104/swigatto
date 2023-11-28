package com.swigatto.swigatto.service.impl;

import com.swigatto.swigatto.dto.request.FoodRequest;
import com.swigatto.swigatto.dto.response.CartResponse;
import com.swigatto.swigatto.dto.response.FoodResponse;
import com.swigatto.swigatto.exception.CustomerNotFoundExcetion;
import com.swigatto.swigatto.exception.MenuItemNotFoundException;
import com.swigatto.swigatto.model.Cart;
import com.swigatto.swigatto.model.Customer;
import com.swigatto.swigatto.model.FoodItem;
import com.swigatto.swigatto.model.MenuItem;
import com.swigatto.swigatto.repositary.CartRepositary;
import com.swigatto.swigatto.repositary.CustomerRepositary;
import com.swigatto.swigatto.repositary.FoodRepositary;
import com.swigatto.swigatto.repositary.MenuRepositary;
import com.swigatto.swigatto.service.CartService;
import com.swigatto.swigatto.transformer.CartStatusTransformer;
import com.swigatto.swigatto.transformer.FoodTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CartImpl implements CartService {
    final CustomerRepositary customerRepositary;
    final MenuRepositary menuRepositary;
    final FoodRepositary foodRepositary;
    final CartRepositary cartRepositary;
    @Autowired
    public CartImpl(CustomerRepositary customerRepositary, MenuRepositary menuRepositary, FoodRepositary foodRepositary, CartRepositary cartRepositary) {
        this.customerRepositary = customerRepositary;
        this.menuRepositary = menuRepositary;
        this.foodRepositary = foodRepositary;
        this.cartRepositary = cartRepositary;
    }



    public CartResponse addToCart(FoodRequest foodRequest) {
        Customer customer = customerRepositary.findByMobileNo(foodRequest.getCustomerMobile());
        if(customer == null) {
            throw new CustomerNotFoundExcetion("Customer not exist !");
        }
        Optional<MenuItem> menuOpt = menuRepositary.findById(foodRequest.getMenuItemId());
        if(menuOpt.isEmpty()) {
            throw new MenuItemNotFoundException("Item not available in the restaurant!!!");
        }
        MenuItem menuItem = menuOpt.get();
        if(!menuItem.getRestaurant().isOpened() || !menuItem.isAvailable()) {
            throw new MenuItemNotFoundException("dish is out of stock in the restaurant");
        }


        List<FoodItem> existingFoodItems = customer.getCart().getFoodItems();
        FoodItem foodItem = existingFoodItems != null && existingFoodItems.size() > 0? existingFoodItems.stream().filter(foodItemVal -> foodRequest.getMenuItemId() == foodItemVal.getMenuItem().getId()).findFirst().orElse(null): null;
        if(foodItem != null) {
            foodItem.setTotalCost(foodItem.getTotalCost()+(foodRequest.getRequiredQuantity()* menuItem.getPrice()));
            foodItem.setRequiredQuantity(foodRequest.getRequiredQuantity()+foodItem.getRequiredQuantity());
        } else {
            foodItem = FoodTransformer.FoodRequestToFoodItem(foodRequest, menuItem);
        }
        foodItem.setCart(customer.getCart());

        FoodItem savedFoodItem = foodRepositary.save(foodItem);

        Cart cart = customer.getCart();
        if(existingFoodItems.stream().noneMatch(foodItemVal -> savedFoodItem.getMenuItem().getId() == foodItemVal.getMenuItem().getId())) cart.getFoodItems().add(savedFoodItem);

        double cartTotal = 0;
        for(FoodItem foodItem1: cart.getFoodItems()) {
            cartTotal += foodItem1.getTotalCost();
        }

        cart.setCartTotal(cartTotal);

        menuItem.getFoodItems().add(savedFoodItem);

        Cart savedCart = cartRepositary.save(cart);
        MenuItem savedMenuItem = menuRepositary.save(menuItem);

        List<FoodResponse> foodResponseList = FoodTransformer.FoodItemsToListOfFoodResponse(cart.getFoodItems());
        return CartStatusTransformer.cartToCartResponse(savedCart);
    }

}
