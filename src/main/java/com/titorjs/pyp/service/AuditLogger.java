package com.titorjs.pyp.service;

import com.titorjs.pyp.model.Resultado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuditLogger {

    public void logConsulta(Resultado resultado) {
        log.info("placa={} | fechaHora={} | libre={} | motivo={}",
                resultado.getPlaca(),
                resultado.getFechaHora(),
                resultado.isLibre(),
                resultado.getMotivo()
        );
    }
}
