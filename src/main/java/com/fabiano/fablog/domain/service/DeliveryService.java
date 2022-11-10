package com.fabiano.fablog.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fabiano.fablog.domain.model.Delivery;
import com.fabiano.fablog.domain.model.StatusDelivery;
import com.fabiano.fablog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliveryService {
    private DeliveryRepository deliveryRepository;

    @Transactional
    public Delivery requestDelivery (Delivery delivery) {
        delivery.setStatus(StatusDelivery.PENDING);
        delivery.setDateOrder(LocalDateTime.now());
        
        return deliveryRepository.save(delivery);

    }
}
