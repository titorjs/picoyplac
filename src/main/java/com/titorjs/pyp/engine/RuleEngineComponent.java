package com.titorjs.pyp.engine;

import com.titorjs.pyp.model.*;
import com.titorjs.pyp.config.RulesConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RuleEngineComponent {

    private final RulesConfig rulesConfig;

    public Optional<Excepcion> isException(LocalDate fecha) {
        return rulesConfig.getExcepciones().stream()
                .filter(e -> e.getFecha().equals(fecha))
                .findFirst();
    }

    public boolean isRestricted(DayOfWeek dia, int digito, LocalTime hora) {
        return rulesConfig.getReglas().stream()
                .filter(r -> r.getDia() == dia)
                .anyMatch(r ->
                        r.getDigitos().contains(digito) &&
                                !hora.isBefore(r.getInicio()) &&
                                !hora.isAfter(r.getFin())
                );
    }
}
