package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.request.DeliveryPartnerRequest;
import com.swigatto.swigatto.model.DeliveryPartner;

import java.util.ArrayList;

public class DeliveryPartnerTransformer {
    public static DeliveryPartner deliverPartnerRequestToDeliveryPartner(DeliveryPartnerRequest deliveryPartnerRequest) {
        return DeliveryPartner.builder()
                .name(deliveryPartnerRequest.getName())
                .mobileNo(deliveryPartnerRequest.getMobileNo())
                .gender(deliveryPartnerRequest.getGender())
                .build();
    }
}
