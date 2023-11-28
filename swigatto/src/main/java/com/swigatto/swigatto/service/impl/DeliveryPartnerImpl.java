package com.swigatto.swigatto.service.impl;

import com.swigatto.swigatto.dto.request.DeliveryPartnerRequest;
import com.swigatto.swigatto.model.DeliveryPartner;
import com.swigatto.swigatto.repositary.DeliveryPartnerRepositary;
import com.swigatto.swigatto.service.DeliveryPartnerService;
import com.swigatto.swigatto.transformer.DeliveryPartnerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeliveryPartnerImpl implements DeliveryPartnerService {
    final DeliveryPartnerRepositary deliveryPartnerRepositary;
    @Autowired
    DeliveryPartnerImpl(DeliveryPartnerRepositary deliveryPartnerRepositary) {
        this.deliveryPartnerRepositary = deliveryPartnerRepositary;
    }
    public String addDeliveryPartner(DeliveryPartnerRequest deliveryPartnerRequest) {
        DeliveryPartner deliverPartner = DeliveryPartnerTransformer.deliverPartnerRequestToDeliveryPartner(deliveryPartnerRequest);
        deliverPartner.setOrders(new ArrayList<>());
        deliveryPartnerRepositary.save(deliverPartner);
        return "Delivery Partner Saved Successfully";
    }
}
