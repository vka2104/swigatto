package com.swigatto.swigatto.service;

import com.swigatto.swigatto.dto.request.CustomerRequest;
import com.swigatto.swigatto.dto.response.CustomerResponse;

public interface CustomerService {
    CustomerResponse addCustomer(CustomerRequest customerRequest);

    CustomerResponse getCustomerByMobileNo(String mobileNo);
}
