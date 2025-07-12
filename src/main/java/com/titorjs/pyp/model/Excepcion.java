package com.titorjs.pyp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class Excepcion {
    private LocalDate fecha;
    private String motivo;
    private boolean aplica;
}
