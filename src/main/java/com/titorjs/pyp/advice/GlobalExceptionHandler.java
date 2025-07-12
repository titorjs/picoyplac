package com.titorjs.pyp.advice;

import com.titorjs.pyp.exception.FechaAnteriorException;
import com.titorjs.pyp.exception.PlacaInvalidaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FechaAnteriorException.class)
    public ResponseEntity<Map<String,String>> handleFechaAnterior(FechaAnteriorException ex) {
        return ResponseEntity
                .badRequest()
                .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(PlacaInvalidaException.class)
    public ResponseEntity<Map<String,String>> handlePlacaInvalida(PlacaInvalidaException ex) {
        return ResponseEntity
                .badRequest()
                .body(Map.of("error", ex.getMessage()));
    }
}
