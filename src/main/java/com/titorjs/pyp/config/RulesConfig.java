package com.titorjs.pyp.config;

import com.titorjs.pyp.model.Excepcion;
import com.titorjs.pyp.model.Regla;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "pico-placa")
@Data
public class RulesConfig {
    private List<Regla> reglas;
    private List<Excepcion> excepciones;
}
