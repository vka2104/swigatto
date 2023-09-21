package com.swigatto.swigatto.repositary;

import com.swigatto.swigatto.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositary extends JpaRepository<Customer, Integer> {
    Customer findByMobileNo(String mobileNo);
}
