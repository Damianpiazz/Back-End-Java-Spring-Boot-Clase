package com.techlab.c13.springboot_demo_c13.repository;

import com.techlab.c13.springboot_demo_c13.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}