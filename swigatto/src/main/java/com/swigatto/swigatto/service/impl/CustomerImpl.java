package com.swigatto.swigatto.service.impl;

import com.swigatto.swigatto.dto.request.CustomerRequest;
import com.swigatto.swigatto.dto.response.CustomerResponse;
import com.swigatto.swigatto.exception.CustomerNotFoundExcetion;
import com.swigatto.swigatto.model.Cart;
import com.swigatto.swigatto.model.Customer;
import com.swigatto.swigatto.repositary.CustomerRepositary;
import com.swigatto.swigatto.service.CustomerService;
import com.swigatto.swigatto.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    CustomerRepositary customerRepositary;

    @Override
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        //convert request to entity
        Customer customer = CustomerTransformer.CustomerRequestToCustomer(customerRequest);

        //setting an empty cart for new users
        Cart cart = Cart.builder().cartTotal(0)
                .customer(customer)
                .foodItems(new ArrayList<>())
                .build();

        //adding cart to the customer
        customer.setCart(cart);

        Customer savedCustomer = customerRepositary.save(customer);
        //convert and return entity to response
        return CustomerTransformer.CustomerToCustomerResponse(savedCustomer);
    }
    public CustomerResponse getCustomerByMobileNo(String mobileNo) {
        Customer customer = customerRepositary.findByMobileNo(mobileNo);
        if(customer == null) throw new CustomerNotFoundExcetion("There is no customer exist with this mobile number");
        //convert and return entity to response
        return CustomerTransformer.CustomerToCustomerResponse(customer);
    }
}
