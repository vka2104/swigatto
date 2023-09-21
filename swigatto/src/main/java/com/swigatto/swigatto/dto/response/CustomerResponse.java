package com.swigatto.swigatto.dto.response;

import com.swigatto.swigatto.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    String name;

    String address;

    String mobileNo;

    CartResponse cart;

}
