package com.techlab.c14.springboot_demo_c14.service;

import com.techlab.c14.springboot_demo_c14.dto.ProductoCreateDTO;
import com.techlab.c14.springboot_demo_c14.dto.ProductoDTO;
import com.techlab.c14.springboot_demo_c14.entity.Producto;
import com.techlab.c14.springboot_demo_c14.exception.ProductoNoEncontradoException;
import com.techlab.c14.springboot_demo_c14.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository repo;
    private final ProductoMapper mapper;

    @Autowired
    public ProductoService(ProductoRepository repo, ProductoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<ProductoDTO> listarTodos() {
        return repo.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductoDTO obtenerPorId(Long id) {
        Producto producto = repo.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        return mapper.toDTO(producto);
    }

    public ProductoDTO crear(ProductoCreateDTO dto) {
        Producto nuevo = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(nuevo));
    }

    public ProductoDTO actualizar(Long id, ProductoCreateDTO dto) {
        Producto producto = repo.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ProductoNoEncontradoException(id));

        mapper.updateEntityFromDTO(dto, producto);
        return mapper.toDTO(repo.save(producto));
    }

    public void eliminar(Long id) {
        if (!repo.existsById(Math.toIntExact(id))) {
            throw new ProductoNoEncontradoException(id);
        }
        repo.deleteById(Math.toIntExact(id));
    }
}