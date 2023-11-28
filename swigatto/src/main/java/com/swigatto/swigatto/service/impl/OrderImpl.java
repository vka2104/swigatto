package com.swigatto.swigatto.service.impl;

import com.swigatto.swigatto.dto.response.FoodResponse;
import com.swigatto.swigatto.dto.response.OrderResponse;
import com.swigatto.swigatto.exception.CustomerNotFoundExcetion;
import com.swigatto.swigatto.model.*;
import com.swigatto.swigatto.repositary.CustomerRepositary;
import com.swigatto.swigatto.repositary.DeliveryPartnerRepositary;
import com.swigatto.swigatto.repositary.OrderRepositary;
import com.swigatto.swigatto.repositary.RestaurantRepositary;
import com.swigatto.swigatto.service.OrderService;
import com.swigatto.swigatto.transformer.FoodTransformer;
import com.swigatto.swigatto.transformer.OrderTransofrmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderImpl implements OrderService {
    final OrderRepositary orderRepositary;
    final CustomerRepositary customerRepositary;
    final DeliveryPartnerRepositary deliveryPartnerRepositary;

    final RestaurantRepositary restaurantRepositary;
    @Autowired
    OrderImpl(OrderRepositary orderRepositary, CustomerRepositary customerRepositary, DeliveryPartnerRepositary deliveryPartnerRepositary, RestaurantRepositary restaurantRepositary) {
        this.orderRepositary = orderRepositary;
        this.customerRepositary = customerRepositary;
        this.deliveryPartnerRepositary = deliveryPartnerRepositary;
        this.restaurantRepositary = restaurantRepositary;
    }
    public OrderResponse placeOrder(String mobileNo) {
        Customer customer = customerRepositary.findByMobileNo(mobileNo);
        if(customer == null) throw new CustomerNotFoundExcetion("There is no customer exist with this mobile number");
        Cart cart = customer.getCart();
        if(cart.getFoodItems() == null || cart.getFoodItems().size() == 0) throw new RuntimeException("Your Cart is Empty");

        DeliveryPartner deliveryPartner = deliveryPartnerRepositary.findRandomPartner();
        Restaurant restaurant = customer.getCart().getFoodItems().get(0).getMenuItem().getRestaurant();

        OrderEntity order = OrderTransofrmer.prepareOrderEntity(customer, deliveryPartner, restaurant);
        OrderEntity savedOrder = orderRepositary.save(order);

        // XXXX need to check with this. there is in this
        order.setCustomer(customer);
        order.setDeliveryPartner(deliveryPartner);
        order.setFoodItems(customer.getCart().getFoodItems());
        order.setRestaurant(restaurant);

        customer.getOrders().add(savedOrder);
        deliveryPartner.getOrders().add(savedOrder);
        restaurant.getOrders().add(savedOrder);

        //in food item adding order id and removing cart id
        for(FoodItem foodItem: cart.getFoodItems()) {
            foodItem.setCart(null);
            foodItem.setOrder(savedOrder);
        }

        cart.setCartTotal(0);
        cart.setFoodItems(new ArrayList<>());

        Customer updatedCustomer = customerRepositary.save(customer);
        DeliveryPartner updatedDeliveryPartner = deliveryPartnerRepositary.save(deliveryPartner);
        Restaurant updatedRestaurant = restaurantRepositary.save(restaurant);
        return OrderTransofrmer.prepareOrderResponse(savedOrder, updatedCustomer, updatedDeliveryPartner, updatedRestaurant);

    }
}
