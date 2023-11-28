package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.request.CustomerRequest;
import com.swigatto.swigatto.dto.response.CustomerResponse;
import com.swigatto.swigatto.dto.response.FoodResponse;
import com.swigatto.swigatto.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerTransformer {
    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest) {
        return Customer.builder().name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .mobileNo(customerRequest.getMobileNo())
                .gender(customerRequest.getGender())
                .build();
    }

    public static CustomerResponse CustomerToCustomerResponse(Customer customer) {
        List<FoodResponse> customerAddedFoodItem = new ArrayList<>();
        if(!customer.getCart().getFoodItems().isEmpty()) {
            customerAddedFoodItem = FoodTransformer.FoodItemsToListOfFoodResponse(customer.getCart().getFoodItems());
        }
        return CustomerResponse.builder()
                .name(customer.getName())
                .address(customer.getAddress())
                .mobileNo(customer.getMobileNo())
                .cartTotal(0)
                .foodItems(customerAddedFoodItem)
                .build();
    }
}
