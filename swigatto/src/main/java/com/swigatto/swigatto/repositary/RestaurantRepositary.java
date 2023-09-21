package com.swigatto.swigatto.repositary;

import com.swigatto.swigatto.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepositary extends JpaRepository<Restaurant, Integer> {
}
