package com.swigatto.swigatto.dto.response;

import com.swigatto.swigatto.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponse {

    String dishName;

    double price;

    FoodCategory category;

    boolean veg;

    int quantityAdded;
}
