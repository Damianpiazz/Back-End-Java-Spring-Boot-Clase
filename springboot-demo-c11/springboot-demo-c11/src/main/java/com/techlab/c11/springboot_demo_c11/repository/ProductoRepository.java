package com.techlab.c11.springboot_demo_c11.repository;

import com.techlab.c11.springboot_demo_c11.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}