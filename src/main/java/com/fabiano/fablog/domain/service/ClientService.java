package com.fabiano.fablog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fabiano.fablog.domain.model.Client;
import com.fabiano.fablog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ClientService {
    
    private ClientRepository clientRepository;

    @Transactional
    public Client save (Client client){
        return clientRepository.save(client);
    }

    public void delete(Long clientId){
        clientRepository.deleteById(clientId);
    }
}
