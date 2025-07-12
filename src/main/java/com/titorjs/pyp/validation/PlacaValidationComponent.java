package com.titorjs.pyp.validation;

import com.titorjs.pyp.exception.PlacaInvalidaException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class PlacaValidationComponent {

    private static final String PLACA_REGEX = "^[A-Z]{3}\\d{4}$";

    public void validateFormat(String placa) {
        if (placa == null || !placa.matches(PLACA_REGEX)) {
            throw new PlacaInvalidaException();
        }
    }

    public int extractDigit(String placa) {
        char ultimo = placa.charAt(placa.length() - 1);
        return Character.getNumericValue(ultimo);
    }
}
