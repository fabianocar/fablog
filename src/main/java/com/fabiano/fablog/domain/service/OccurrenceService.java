package com.fabiano.fablog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fabiano.fablog.domain.model.Delivery;
import com.fabiano.fablog.domain.model.Occurrence;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OccurrenceService {

    private FindDeliveryService findDeliveryService;
    
    @Transactional
    public Occurrence register (Long deliveryId, String description){
        Delivery delivery = findDeliveryService.find(deliveryId);

        return delivery.addOccurrence(description);
    }
}
