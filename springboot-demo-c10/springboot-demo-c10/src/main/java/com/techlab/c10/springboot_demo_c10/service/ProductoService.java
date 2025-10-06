package com.techlab.c10.springboot_demo_c10.service;

import com.techlab.c10.springboot_demo_c10.model.Producto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductoService {

    public List<Producto> obtenerProductos() {
        return Arrays.asList(
                new Producto("☕ Café", 250.0, 100),
                new Producto("🍵 Té Verde", 180.0, 75),
                new Producto("🥐 Medialuna", 120.0, 50)
        );
    }
}