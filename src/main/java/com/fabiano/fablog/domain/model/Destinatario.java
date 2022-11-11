package com.fabiano.fablog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Embeddable
public class Destinatario {

    @NotBlank
    @Column(name = "destinatario_name")
    private String name;

    @NotBlank
    @Column(name = "destinatario_address")
    private String address;

    @NotBlank
    @Column(name = "destinatario_number")
    private String number;

    @NotBlank
    @Column(name = "destinatario_complement")
    private String complement;

}
