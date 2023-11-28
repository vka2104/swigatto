package com.swigatto.swigatto.repositary;

import com.swigatto.swigatto.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositary extends JpaRepository<OrderEntity, Integer> {
}
