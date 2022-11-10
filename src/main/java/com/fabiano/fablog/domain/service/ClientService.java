package com.fabiano.fablog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fabiano.fablog.domain.exception.BusinessException;
import com.fabiano.fablog.domain.model.Client;
import com.fabiano.fablog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ClientService {
    
    private ClientRepository clientRepository;

    public Client find(Long clientId){
        return clientRepository.findById(clientId)
            .orElseThrow(() -> new BusinessException("Cliente não encontrado!"));
    }

    @Transactional
    public Client save (Client client){
        boolean emailExist = clientRepository.findByEmail(client.getEmail())
            .stream()
            .anyMatch(ce -> !ce.equals(client));
        if(emailExist){
            throw new BusinessException("Já existe um cliente cadastrado com esse email!");
        }

        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long clientId){
        clientRepository.deleteById(clientId);
    }
}
