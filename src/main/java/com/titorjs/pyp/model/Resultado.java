package com.titorjs.pyp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Resultado {

    private String placa;
    private LocalDateTime fechaHora;
    private boolean libre;
    private String motivo; // null si no hay excepción
}
