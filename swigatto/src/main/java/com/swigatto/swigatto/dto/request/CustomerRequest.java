package com.swigatto.swigatto.dto.request;

import com.swigatto.swigatto.Enum.Gender;
import com.swigatto.swigatto.model.Cart;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    String name;

    String email;

    String address;

    String mobileNo;

    Gender gender;

}
