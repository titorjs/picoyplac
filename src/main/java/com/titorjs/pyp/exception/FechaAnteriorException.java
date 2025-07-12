package com.titorjs.pyp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción que se lanza cuando la fecha/hora consultada es anterior al momento actual.
 * Se asocia a un HTTP 400 Bad Request.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FechaAnteriorException extends RuntimeException {

    public FechaAnteriorException() {
        super("La fecha/hora de consulta no puede ser anterior al momento actual");
    }

    public FechaAnteriorException(String message) {
        super(message);
    }

    public FechaAnteriorException(String message, Throwable cause) {
        super(message, cause);
    }

}
