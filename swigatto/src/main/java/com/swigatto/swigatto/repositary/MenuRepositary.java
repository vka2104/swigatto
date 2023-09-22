package com.swigatto.swigatto.repositary;

import com.swigatto.swigatto.Enum.FoodCategory;
import com.swigatto.swigatto.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface MenuRepositary extends JpaRepository<MenuItem, Integer> {
    List<MenuItem> findByFoodCategory(FoodCategory foodCategory);
    @Query(value = "SELECT m FROM MenuItem m WHERE m.foodCategory = 'MAIN_COURSE' AND m.price > :price AND m.restaurant.id = :restaurantId")
    List<MenuItem> getFoodsByPriceAndRestaurantHQL(double price, int restaurantId);
}
