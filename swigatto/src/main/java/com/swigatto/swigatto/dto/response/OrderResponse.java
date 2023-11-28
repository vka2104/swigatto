package com.swigatto.swigatto.dto.response;

import com.swigatto.swigatto.model.Customer;
import com.swigatto.swigatto.model.DeliveryPartner;
import com.swigatto.swigatto.model.FoodItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    String orderId; //UUID

    double orderTotal;

    Date orderTime;

    String customerName;

    String customerMobileNo;

    String deliveryPartnerName;

    String deliverPartnerMobileNo;

    String restaurantName;

    List<FoodResponse> foodResponseList ;
}
