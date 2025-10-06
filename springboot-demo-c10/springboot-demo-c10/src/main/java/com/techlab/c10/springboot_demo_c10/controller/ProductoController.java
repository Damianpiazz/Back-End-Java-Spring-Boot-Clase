package com.techlab.c10.springboot_demo_c10.controller;

import com.techlab.c10.springboot_demo_c10.model.Producto;
import com.techlab.c10.springboot_demo_c10.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.obtenerProductos();
    }
}