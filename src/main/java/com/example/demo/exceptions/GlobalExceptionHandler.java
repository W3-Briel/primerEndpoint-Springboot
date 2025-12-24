package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonaError.class)
    public ResponseEntity<Map<String, Object>> datosIncompletos(PersonaError error){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value()); // 400
        errorResponse.put("error", "Regla de Negocio Violada");
        errorResponse.put("message", error.getMessage()); // El mensaje que pusiste en el Service

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
