package com.swigatto.swigatto.dto.response;

import com.swigatto.swigatto.Enum.RestaurantCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResponse {
    String name;

    String location;

    String contactNumber;

    List<FoodResponse> menu;
}
