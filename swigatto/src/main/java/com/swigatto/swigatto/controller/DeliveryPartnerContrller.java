package com.swigatto.swigatto.controller;

import com.swigatto.swigatto.dto.request.DeliveryPartnerRequest;
import com.swigatto.swigatto.service.DeliveryPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliverypartner")
public class DeliveryPartnerContrller {
    final DeliveryPartnerService deliveryPartnerService;
   @Autowired
    DeliveryPartnerContrller(DeliveryPartnerService deliveryPartnerService) {
        this.deliveryPartnerService = deliveryPartnerService;
    }
    @PostMapping("/add")
    public ResponseEntity addDeliveryPartner(@RequestBody DeliveryPartnerRequest deliveryPartnerRequest) {
        String message = deliveryPartnerService.addDeliveryPartner(deliveryPartnerRequest);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
