package com.titorjs.pyp.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Se lanza cuando la placa no cumple con el patrón 3 letras mayúsculas + 4 dígitos.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlacaInvalidaException extends RuntimeException {
    public PlacaInvalidaException() {
        super("Formato de placa inválido: debe ser 3 letras mayúsculas y 4 dígitos");
    }
    public PlacaInvalidaException(String message) {
        super(message);
    }
}
