package com.fabiano.fablog.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {
    
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @Embedded
    private Destinatario destinatario;

    private BigDecimal tax;

    @Enumerated(EnumType.STRING)
    private StatusDelivery status;

    @Column(name = "dateorder")
    private LocalDateTime dateOrder;

    @Column(name = "datefinal")
    private LocalDateTime dateFinal;
}
