package com.swigatto.swigatto.repositary;

import com.swigatto.swigatto.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositary extends JpaRepository<Customer, Integer> {
    Customer findByMobileNo(String mobileNo);
}
