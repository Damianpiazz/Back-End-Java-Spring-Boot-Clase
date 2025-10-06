package com.techlab.c14.springboot_demo_c14.service;

import com.techlab.c14.springboot_demo_c14.dto.ProductoCreateDTO;
import com.techlab.c14.springboot_demo_c14.dto.ProductoDTO;
import com.techlab.c14.springboot_demo_c14.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoDTO toDTO(Producto entity) {
        return new ProductoDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getPrecio(),
                entity.getCantidadEnStock(),
                entity.getDescripcion(),
                entity.getCategoria()
        );
    }

    public Producto toEntity(ProductoCreateDTO dto) {
        return new Producto(
                dto.getNombre(),
                dto.getPrecio(),
                dto.getCantidadEnStock(),
                dto.getDescripcion(),
                dto.getCategoria()
        );
    }

    public void updateEntityFromDTO(ProductoCreateDTO dto, Producto entity) {
        entity.setNombre(dto.getNombre());
        entity.setPrecio(dto.getPrecio());
        entity.setCantidadEnStock(dto.getCantidadEnStock());
        entity.setDescripcion(dto.getDescripcion());
        entity.setCategoria(dto.getCategoria());
    }
}