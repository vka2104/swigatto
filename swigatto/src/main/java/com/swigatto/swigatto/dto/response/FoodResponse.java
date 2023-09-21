package com.swigatto.swigatto.dto.response;

import com.swigatto.swigatto.Enum.FoodCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    FoodCategory foodCategory;

    boolean veg;
}
