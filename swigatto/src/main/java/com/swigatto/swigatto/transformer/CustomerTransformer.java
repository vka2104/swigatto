package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.request.CustomerRequest;
import com.swigatto.swigatto.dto.response.CartResponse;
import com.swigatto.swigatto.dto.response.CustomerResponse;
import com.swigatto.swigatto.model.Customer;

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
        CartResponse cartResponse = CartTransformer.CartToCartResponse(customer.getCart());
        return CustomerResponse.builder()
                .name(customer.getName())
                .address(customer.getAddress())
                .mobileNo(customer.getMobileNo())
                .cart(cartResponse)
                .build();
    }
}
