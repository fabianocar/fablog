package com.fabiano.fablog.api.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DestinatarioInput {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String number;

    @NotBlank
    private String complement;
}
