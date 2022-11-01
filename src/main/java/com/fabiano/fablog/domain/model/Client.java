package com.fabiano.fablog.domain.model;

import lombok.Data;

@Data
public class Client {
    
    private Long id;
    private String name;
    private String mail;
    private String phone;

}
