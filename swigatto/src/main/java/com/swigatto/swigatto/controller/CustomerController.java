package com.swigatto.swigatto.controller;

import com.swigatto.swigatto.dto.request.CustomerRequest;
import com.swigatto.swigatto.dto.response.CustomerResponse;
import com.swigatto.swigatto.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    //constructor injection
//    final CustomerService customerService;

//    @Autowired
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }


    //field injection
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse);
    }

    @GetMapping("/getCustomer/mobile/{mobileNo}")
    public ResponseEntity getCustomerByMobileNo(@PathVariable String mobileNo) {
        try {
            CustomerResponse customerResponse = customerService.getCustomerByMobileNo(mobileNo);
            return ResponseEntity.status(HttpStatus.FOUND).body(customerResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
