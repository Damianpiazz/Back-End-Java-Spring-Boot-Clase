package com.techlab.c14.springboot_demo_c14.controller;

import com.techlab.c14.springboot_demo_c14.dto.ProductoCreateDTO;
import com.techlab.c14.springboot_demo_c14.dto.ProductoDTO;
import com.techlab.c14.springboot_demo_c14.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Productos", description = "Operaciones CRUD sobre productos")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    @Autowired
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // ================================
    // GET - Listar todos los productos
    // ================================
    @Operation(
            summary = "Listar todos los productos",
            description = "Retorna una lista con todos los productos registrados en la base de datos."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // ==================================
    // GET - Obtener un producto por ID
    // ==================================
    @Operation(
            summary = "Obtener un producto por ID",
            description = "Busca y devuelve un producto específico por su identificador único (ID)."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Producto encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    // ==================================
    // POST - Crear un nuevo producto
    // ==================================
    @Operation(
            summary = "Crear un nuevo producto",
            description = "Permite registrar un nuevo producto en la base de datos enviando un objeto JSON con sus datos."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Producto creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public ResponseEntity<ProductoDTO> crear(@RequestBody ProductoCreateDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    // ==================================
    // PUT - Actualizar un producto existente
    // ==================================
    @Operation(
            summary = "Actualizar un producto existente",
            description = "Actualiza los datos de un producto ya existente mediante su ID y los nuevos valores enviados en el cuerpo de la petición."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizar(@PathVariable Long id, @RequestBody ProductoCreateDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    // ==================================
    // DELETE - Eliminar un producto por ID
    // ==================================
    @Operation(
            summary = "Eliminar un producto por ID",
            description = "Elimina un producto existente de la base de datos usando su identificador único (ID)."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Producto eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}