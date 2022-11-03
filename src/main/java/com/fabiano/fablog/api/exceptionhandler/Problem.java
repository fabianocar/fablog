package com.fabiano.fablog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Problem {
    private Integer status;
    private LocalDateTime dateHour;
    private String title;
    private List<Fild> filds;
}
