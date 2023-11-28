package com.swigatto.swigatto.repositary;

import com.swigatto.swigatto.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepositary extends JpaRepository<Cart, Integer> {
}
