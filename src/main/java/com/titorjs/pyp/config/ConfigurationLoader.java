package com.titorjs.pyp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConfigurationLoader {

    private final RulesConfig rulesConfig;

    public RulesConfig getRulesConfig() {
        return rulesConfig;
    }

    //TODO: Recarga dinámica del config
}
