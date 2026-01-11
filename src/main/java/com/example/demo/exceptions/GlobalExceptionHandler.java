package com.example.demo.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonaError.class)
    public ResponseEntity<Map<String, Object>> datosIncompletos(PersonaError error, HttpServletRequest req){
        int code = HttpStatus.BAD_REQUEST.value();
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", code); // 400
        errorResponse.put("error", "Regla de Negocio Violada");
        errorResponse.put("message", error.getMessage());
        errorResponse.put("path", req.getRequestURI());

        return ResponseEntity.status(code).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> errorEnFormato(MethodArgumentNotValidException error,HttpServletRequest req){
        int code = HttpStatus.BAD_REQUEST.value();
        Map<String,Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", code);
        errorResponse.put("message", error.getDetailMessageArguments());
        errorResponse.put("path",req.getRequestURI());

        return ResponseEntity.status(code).body(errorResponse);
    }

    @ExceptionHandler(PersonaNotFound.class)
    public ResponseEntity<Map<String, Object>> notFound(PersonaNotFound error, HttpServletRequest req){
        int code = HttpStatus.NOT_FOUND.value();

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", code); // 400
        errorResponse.put("error", "NotFound");
        errorResponse.put("message", error.getMessage());
        errorResponse.put("path", req.getRequestURI());

        return ResponseEntity.status(code).body(errorResponse);
    }

}
