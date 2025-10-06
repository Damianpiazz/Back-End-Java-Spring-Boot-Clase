package com.techlab.c14.springboot_demo_c14.repository;

import com.techlab.c14.springboot_demo_c14.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}