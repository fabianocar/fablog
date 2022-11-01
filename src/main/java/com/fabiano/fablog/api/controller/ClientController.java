package com.fabiano.fablog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabiano.fablog.domain.model.Client;

@RestController
public class ClientController {
    @GetMapping("/client")
    public List<Client> list() {
        Client client = new Client();
        client.setId(1L);
        client.setName("João");
        client.setMail("joao@gmail.com");
        client.setPhone("51989999999"); 
        
        Client client1 = new Client();
        client1.setId(2L);
        client1.setName("Maria");
        client1.setMail("maria@gmail.com");
        client1.setPhone("51989999999"); 

        return Arrays.asList(client, client1); 
    }
}
