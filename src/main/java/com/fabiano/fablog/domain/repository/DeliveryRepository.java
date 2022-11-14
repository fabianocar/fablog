package com.fabiano.fablog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.fablog.domain.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    
}
