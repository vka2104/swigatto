package com.swigatto.swigatto.repositary;

import com.swigatto.swigatto.model.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPartnerRepositary extends JpaRepository<DeliveryPartner, Integer> {

    @Query(value = "select d from DeliveryPartner d order by RAND() LIMIT 1")
    DeliveryPartner findRandomPartner();
}
