package com.techlab.c14.springboot_demo_c14.exception;

public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(Long id) {
        super("El producto con ID " + id + " no fue encontrado.");
    }
}