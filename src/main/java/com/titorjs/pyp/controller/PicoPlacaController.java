package com.titorjs.pyp.controller;

import com.titorjs.pyp.model.Resultado;
import com.titorjs.pyp.service.PicoPlacaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/picoPlaca")
@RequiredArgsConstructor
public class PicoPlacaController {

    private final PicoPlacaService service;

    @GetMapping
    public Resultado getPicoPlaca(
            @RequestParam String placa,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime hora
    ) {
        LocalDateTime fechaHora = LocalDateTime.of(fecha, hora);

        return service.consultar(placa, fechaHora);
    }
}
