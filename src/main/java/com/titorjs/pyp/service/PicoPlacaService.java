package com.titorjs.pyp.service;

import com.titorjs.pyp.exception.FechaAnteriorException;
import com.titorjs.pyp.engine.RuleEngineComponent;
import com.titorjs.pyp.model.Resultado;
import com.titorjs.pyp.validation.PlacaValidationComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PicoPlacaService {

    private final PlacaValidationComponent placaValidator;
    private final RuleEngineComponent ruleEngine;
    private final AuditLogger auditLogger;

    public Resultado consultar(String placa, LocalDateTime fechaHora) {
        if (fechaHora.isBefore(LocalDateTime.now())) {
            throw new FechaAnteriorException();
        }

        placaValidator.validateFormat(placa);

        int digito = placaValidator.extractDigit(placa);

        var excepcionOpt = ruleEngine.isException(fechaHora.toLocalDate());
        if (excepcionOpt.isPresent()) {
            var ex = excepcionOpt.get();
            boolean libre = !ex.isAplica();
            Resultado res = new Resultado(placa, fechaHora, libre, ex.getMotivo());
            auditLogger.logConsulta(res);
            return res;
        }

        boolean restringido = ruleEngine.isRestricted(
                fechaHora.getDayOfWeek(), digito, fechaHora.toLocalTime()
        );
        Resultado res = new Resultado(placa, fechaHora, !restringido, null);
        auditLogger.logConsulta(res);
        return res;
    }
}
