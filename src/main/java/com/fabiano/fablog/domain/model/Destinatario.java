package com.fabiano.fablog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Destinatario {

    @Column(name = "destinatario_name")
    private String name;

    @Column(name = "destinatario_address")
    private String address;

    @Column(name = "destinatario_number")
    private String number;

    @Column(name = "destinatario_complement")
    private String complement;

}
