package com.fabiano.fablog.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabiano.fablog.domain.model.Client;
import com.fabiano.fablog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClientController {
    
    private ClientRepository clientRepository;

    @GetMapping("/client")
    public List<Client> list() {
     return clientRepository.findAll();
    }
}
