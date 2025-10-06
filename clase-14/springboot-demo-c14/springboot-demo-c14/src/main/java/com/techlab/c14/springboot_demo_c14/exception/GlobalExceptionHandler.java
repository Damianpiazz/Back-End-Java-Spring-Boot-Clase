package com.techlab.c14.springboot_demo_c14.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleProductoNoEncontrado(ProductoNoEncontradoException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Producto no encontrado");
        response.put("mensaje", ex.getMessage());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Error interno del servidor");
        response.put("mensaje", ex.getMessage());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
