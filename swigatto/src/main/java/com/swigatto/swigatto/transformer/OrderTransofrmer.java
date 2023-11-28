package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.response.FoodResponse;
import com.swigatto.swigatto.dto.response.OrderResponse;
import com.swigatto.swigatto.model.Customer;
import com.swigatto.swigatto.model.DeliveryPartner;
import com.swigatto.swigatto.model.OrderEntity;
import com.swigatto.swigatto.model.Restaurant;

import java.util.List;
import java.util.UUID;

public class OrderTransofrmer {
    public static OrderEntity prepareOrderEntity(Customer customer, DeliveryPartner deliveryPartner, Restaurant restaurant) {
        return OrderEntity.builder()
                .orderId(String.valueOf(UUID.randomUUID()))
                .orderTotal(customer.getCart().getCartTotal())
                .build();
    }

    public static OrderResponse prepareOrderResponse(OrderEntity savedOrder, Customer updatedCustomer, DeliveryPartner updatedDeliveryPartner, Restaurant updatedRestaurant) {
        List<FoodResponse> foodResponseList = FoodTransformer.FoodItemsToListOfFoodResponse(savedOrder.getFoodItems());
        return OrderResponse.builder()
                .orderId(savedOrder.getOrderId())
                .orderTotal(savedOrder.getOrderTotal())
                .orderTime(savedOrder.getOrderTime())
                .customerName(updatedCustomer.getName())
                .customerMobileNo(updatedCustomer.getMobileNo())
                .deliveryPartnerName(updatedDeliveryPartner.getName())
                .deliverPartnerMobileNo(updatedDeliveryPartner.getMobileNo())
                .restaurantName(updatedRestaurant.getName())
                .foodResponseList(foodResponseList)
                .build();
    }
}
