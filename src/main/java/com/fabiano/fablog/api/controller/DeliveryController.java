package com.fabiano.fablog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fabiano.fablog.api.assembler.DeliveryMapper;
import com.fabiano.fablog.api.dto.DeliveryDTO;
import com.fabiano.fablog.api.dto.input.DeliveryInput;
import com.fabiano.fablog.domain.model.Delivery;
import com.fabiano.fablog.domain.repository.DeliveryRepository;
import com.fabiano.fablog.domain.service.DeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    
    private DeliveryRepository deliveryRepository;
    private DeliveryService deliveryService;
    private DeliveryMapper deliveryMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryDTO requestDelivery (@Valid @RequestBody DeliveryInput deliveryInput){
        Delivery newDelivery = deliveryMapper.toEntity(deliveryInput);
        
        Delivery deliveryRequested = deliveryService.requestDelivery(newDelivery);
        return deliveryMapper.toModel(deliveryRequested);
    }

    @GetMapping
    public List<DeliveryDTO> list(){
        return deliveryMapper.toCollectionModel(deliveryRepository.findAll());
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryDTO> find(@PathVariable Long deliveryId){
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> ResponseEntity.ok(deliveryMapper.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());

    }
}
