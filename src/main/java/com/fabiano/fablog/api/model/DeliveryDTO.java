package com.fabiano.fablog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fabiano.fablog.domain.model.StatusDelivery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryDTO {

    private Long id;
    private String name;
    private DestinatarioDTO destinatario;
    private BigDecimal tax;
    private StatusDelivery status;
    private OffsetDateTime dateOrder;
    private OffsetDateTime dateFinal;
}