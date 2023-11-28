package com.swigatto.swigatto.repositary;

import com.swigatto.swigatto.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepositary extends JpaRepository<FoodItem, Integer> {
}
