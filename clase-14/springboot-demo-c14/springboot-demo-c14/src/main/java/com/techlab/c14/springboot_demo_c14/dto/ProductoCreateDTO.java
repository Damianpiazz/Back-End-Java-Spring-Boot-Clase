package com.techlab.c14.springboot_demo_c14.dto;

public class ProductoCreateDTO {
    private String nombre;
    private Double precio;
    private Integer cantidadEnStock;
    private String descripcion;
    private String categoria;

    public ProductoCreateDTO() {}

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Integer getCantidadEnStock() { return cantidadEnStock; }
    public void setCantidadEnStock(Integer cantidadEnStock) { this.cantidadEnStock = cantidadEnStock; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}