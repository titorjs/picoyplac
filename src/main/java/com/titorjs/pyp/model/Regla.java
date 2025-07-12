package com.titorjs.pyp.model;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Data
public class Regla {
    private DayOfWeek dia;
    private List<Integer> digitos;
    private LocalTime inicio;
    private LocalTime fin;
}
