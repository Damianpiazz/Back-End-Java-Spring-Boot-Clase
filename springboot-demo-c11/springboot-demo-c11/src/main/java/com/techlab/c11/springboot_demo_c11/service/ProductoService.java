package com.techlab.c11.springboot_demo_c11.service;

import com.techlab.c11.springboot_demo_c11.model.Producto;
import com.techlab.c11.springboot_demo_c11.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> actualizar(Long id, Producto datosNuevos) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(datosNuevos.getNombre());
            producto.setPrecio(datosNuevos.getPrecio());
            producto.setStock(datosNuevos.getStock());
            return productoRepository.save(producto);
        });
    }

    public boolean eliminar(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
