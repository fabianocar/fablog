package com.fabiano.fablog.domain.service;

import org.springframework.stereotype.Service;

import com.fabiano.fablog.domain.model.Delivery;
import com.fabiano.fablog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class finalizationDeliveryService {

    private DeliveryRepository deliveryRepository;    
    private FindDeliveryService findDeliveryService;

    public void finalization(Long deliveryId){
        Delivery delivery = findDeliveryService.find(deliveryId);

        delivery.finalize();   

        deliveryRepository.save(delivery);

    }
}
