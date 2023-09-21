package com.swigatto.swigatto.dto.request;

import com.swigatto.swigatto.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodRequest {
    int restaurantId;

    String dishName;

    double price;

    FoodCategory foodCategory;

    boolean veg;

    boolean available;
}
