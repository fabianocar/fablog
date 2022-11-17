package com.fabiano.fablog.api.dto.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryInput {

    @Valid
    @NotNull
    private ClientIdInput client;
    
    @Valid
    @NotNull
    private DestinatarioInput destinatario;

    @Valid
    @NotNull
    private BigDecimal tax;
}