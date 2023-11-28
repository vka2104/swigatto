package com.swigatto.swigatto.dto.request;

import com.swigatto.swigatto.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPartnerRequest {
    String name;

    String mobileNo;

    Gender gender;
}
