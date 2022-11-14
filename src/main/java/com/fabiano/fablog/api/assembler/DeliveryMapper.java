package com.fabiano.fablog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.fabiano.fablog.api.dto.DeliveryDTO;
import com.fabiano.fablog.api.dto.input.DeliveryInput;
import com.fabiano.fablog.domain.model.Delivery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeliveryMapper {
    
    private ModelMapper modelMapper;
    
    public DeliveryDTO toModel(Delivery delivery){
        return modelMapper.map(delivery, DeliveryDTO.class);
    }

    public List<DeliveryDTO> toCollectionModel(List<Delivery> delivery){
        return delivery.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Delivery toEntity(DeliveryInput deliveryInput){
        return modelMapper.map(deliveryInput, Delivery.class);
    }
}
