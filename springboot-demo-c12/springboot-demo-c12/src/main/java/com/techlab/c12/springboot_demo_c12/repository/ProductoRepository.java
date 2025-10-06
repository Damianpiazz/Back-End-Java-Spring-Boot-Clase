package com.techlab.c12.springboot_demo_c12.repository;

import com.techlab.c12.springboot_demo_c12.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}