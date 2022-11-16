package com.fabiano.fablog.domain.service;

import org.springframework.stereotype.Service;

import com.fabiano.fablog.domain.exception.BusinessException;
import com.fabiano.fablog.domain.model.Delivery;
import com.fabiano.fablog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FindDeliveryService {
    
    private DeliveryRepository deliveryRepository;

    public Delivery find(Long deliveryId){
        return deliveryRepository.findById(deliveryId)
            .orElseThrow(() -> new BusinessException("Entrega não encontrada!"));
    }
}
