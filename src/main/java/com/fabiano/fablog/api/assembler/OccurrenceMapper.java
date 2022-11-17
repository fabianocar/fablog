package com.fabiano.fablog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.fabiano.fablog.api.dto.OccurrenceDTO;
import com.fabiano.fablog.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OccurrenceMapper {
    
    private ModelMapper modelMapper;

    public OccurrenceDTO toModel(Occurrence occurrence){
        return modelMapper.map(occurrence, OccurrenceDTO.class);
    }

    public List<OccurrenceDTO> toCollectionModel(List<Occurrence> occurrences){
        return occurrences.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
