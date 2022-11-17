package com.fabiano.fablog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fabiano.fablog.api.assembler.OccurrenceMapper;
import com.fabiano.fablog.api.dto.OccurrenceDTO;
import com.fabiano.fablog.api.dto.input.OccurrenceInput;
import com.fabiano.fablog.domain.model.Delivery;
import com.fabiano.fablog.domain.model.Occurrence;
import com.fabiano.fablog.domain.service.FindDeliveryService;
import com.fabiano.fablog.domain.service.OccurrenceService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery/{deliveryId}/occurrence")
public class OccurrenceController {

    private FindDeliveryService findDeliveryService;
    private OccurrenceService occurrenceService;
    private OccurrenceMapper occurrenceMapper;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrenceDTO register(@PathVariable Long deliveryId,
            @Valid @RequestBody OccurrenceInput occurrenceInput){

            Occurrence occurrenceRegistered = occurrenceService
                .register(deliveryId, occurrenceInput.getDescription());        
            return occurrenceMapper.toModel(occurrenceRegistered);
            
    }
    
    @GetMapping
    public List<OccurrenceDTO> Lister(@PathVariable Long deliveryId){
        Delivery delivery = findDeliveryService.find(deliveryId);

        return occurrenceMapper.toCollectionModel(delivery.getOccurrence());
    }
}
