# Clase 15 | Repaso General y Preparación del Proyecto Final

---

## Índice

### Clase 15 | Repaso General y Preparación del Proyecto Final
- Revisión de todos los conceptos aprendidos.
- Resolución de dudas y problemas pendientes.
- Trabajo en el proyecto final: implementación completa del backend.
- Orientaciones para la presentación del proyecto.

### Clase 16 | Presentación de Proyectos
- Presentación de los proyectos por parte de los alumnos.
- Demostración de la funcionalidad del backend integrado con el frontend.
- Corrección y feedback en vivo por parte del profesor.
- Discusión de las soluciones implementadas y buenas prácticas.
- Reflexión final y recomendaciones para futuros desarrollos.

---

## Objetivos de la Clase

### Reafirmar conceptos clave
Revisaremos los puntos más importantes del curso.

### Profundizar en buenas prácticas
Exploraremos técnicas de programación en Java.

### Resolver dudas técnicas
Abordaremos problemas antes de la presentación final.

### Brindar pautas de presentación
Guiaremos la exposición del proyecto final.

---

## Estructura y Modularización

La **estructura** en programación se refiere a cómo organizamos nuestro código en diferentes carpetas y archivos de manera lógica y ordenada.  
La **modularización** es el proceso de dividir el código en componentes independientes y reutilizables, cada uno con una responsabilidad específica.

### Arquitectura en capas (Java)
- **Controller** → Controladores REST en `com.empresa.proyecto.controller`
- **Service** → Lógica de negocio en `com.empresa.proyecto.service`
- **Repository** → Acceso a datos con JPA en `com.empresa.proyecto.repository`
- **Model** → Entidades y modelos en `com.empresa.proyecto.model`

---

## Principios de Programación Orientada a Objetos (POO)

La **Programación Orientada a Objetos (POO)** organiza el código en **objetos** que contienen datos y comportamiento.

### Pilares Fundamentales
#### Encapsulamiento
Permite ocultar los detalles internos de un objeto y exponer solo lo necesario.

#### Herencia
Permite que una clase hija herede atributos y métodos de una clase padre.

#### Polimorfismo
Permite que objetos de diferentes clases respondan al mismo método de diferentes formas.

### Ejemplo de Herencia y Polimorfismo

```java
public abstract class Animal {
    public abstract void hacerSonido();
}

public class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau Guau");
    }
}
```

**Explicación:**  
La clase `Animal` define un método abstracto `hacerSonido()`, que se implementa de forma distinta en cada subclase. En este caso, la clase `Perro` da su propia implementación.

---

## Manejo de Base de Datos con JPA

```java
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
}
```

La clase `Usuario` representa una entidad persistente en la base de datos.  
Las anotaciones `@Entity`, `@Id` y `@GeneratedValue` indican que es una tabla con un campo autogenerado.

### Consultas Personalizadas con JPA

```java
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    Usuario encontrarPorEmail(String email);
}
```

Permite realizar consultas personalizadas mediante JPQL.

---

## Exposición de APIs REST

```java
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity obtenerUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(id));
    }
}
```

Define endpoints REST para la gestión de usuarios.

---

## Integración con el Front-End

```java
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }
        };
    }
}
```

Configura CORS para permitir la comunicación entre frontend (puerto 3000) y backend.

---

## Manejo de Errores

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
```

Centraliza el manejo de excepciones mediante `@ControllerAdvice`.

---

## Entrega de Proyecto Final

### Opciones de Proyecto
1. Usar el proyecto final del curso de Front-End JS.
2. Usar un template proporcionado.

### Funcionalidades obligatorias
- CRUD de productos.
- Búsqueda por nombre o ID.
- Actualización de datos (precio o stock).
- Eliminación con confirmación.
- Creación de pedidos.
- Gestión de stock.
- Historial de pedidos por usuario.

---

## Ejemplo de flujo del sistema

### 1️⃣ Listar productos
`GET /api/productos` → retorna todos los productos.

### 2️⃣ Agregar producto
`POST /api/productos` con JSON del producto.

### 3️⃣ Crear pedido
`POST /api/pedidos` con productos seleccionados.

### 4️⃣ Consultar pedidos
`GET /api/usuarios/{id}/pedidos` → historial de pedidos.

---

## Requerimientos Técnicos

### Tipos de datos
- `int` → IDs, cantidades.
- `double` → precios.
- `String` → nombres, descripciones.

### Colecciones
- `ArrayList<Producto>` → lista de productos.
- `Map<Integer, Integer>` → ID de producto → cantidad.

### Excepciones personalizadas
- `StockInsuficienteException`

### Organización del código
```
com.techlab.productos
com.techlab.pedidos
com.techlab.excepciones
```

---

## Presentación de Proyectos

### Aspectos clave
- **Contexto y Solución:** problema y propuesta.
- **Demostración:** mostrar funcionalidades.
- **Arquitectura:** explicar estructura.
- **Aprendizajes:** compartir desafíos técnicos.

### Consejos finales
- Verificar dependencias y entorno.
- Practicar la presentación.
- Tener plan de contingencia (capturas o video).