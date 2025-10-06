# Clase 14 | Integración del Backend con el Frontend

---

## Índice

### Clase 14 | Integración del Backend con el Frontend

- Configuración de CORS para permitir la comunicación con el frontend.
- Consumo de la API desde el frontend existente.
- Pruebas integrales del sistema completo.
- Resolución de problemas comunes en la integración.

### Clase 15 | Repaso General y Preparación del Proyecto Final

- Revisión de todos los conceptos aprendidos.
- Resolución de dudas y problemas pendientes.
- Trabajo en el proyecto final: implementación completa del backend.
- Orientaciones para la presentación del proyecto.

---

## Objetivos de la Clase

### Entender CORS

Comprender qué es CORS y por qué es necesario configurarlo para la comunicación entre frontend y backend.

### Consumir la API

Aprender a consumir la API desde el frontend utilizando `fetch()` u otros métodos, procesando las respuestas JSON.

### Integrar el Carrito

Integrar el carrito de compras del frontend con la API, mostrando productos reales y permitiendo operaciones.

### Pruebas y Optimización

Realizar pruebas integrales y resolver problemas comunes de integración, optimizando la API.

---

## CORS

### Entendiendo el Problema CORS

#### ¿Qué es CORS?

CORS (Cross-Origin Resource Sharing) es un mecanismo de seguridad que permite a la API indicar qué orígenes externos pueden acceder a sus recursos.

#### ¿Por qué es necesario?

Si el frontend y la API corren en diferentes dominios o puertos, el navegador bloquea las solicitudes AJAX por seguridad. CORS resuelve este problema.

---

## Soluciones con Spring Boot: `@CrossOrigin`

```java
@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoController {
    // ...
}
```

`@CrossOrigin` permite solicitudes desde `http://localhost:3000`.  
Alternativamente, se puede configurar globalmente con un `WebMvcConfigurer` para habilitar CORS en todo el proyecto.

---

## Fusionando el Front con el Back

### Consumo de la API desde el Frontend: `fetch()`

En esta clase, vamos a explorar cómo se utiliza la función `fetch()` en JavaScript para consumir la API que hemos creado con Spring Boot.  
`fetch()` es una función que nos permite hacer solicitudes HTTP, como GET, POST, PUT, DELETE, a una URL determinada, y obtener una respuesta de la API.

---

### 1) Crear productos

**Código Backend:**

```java
@PostMapping
public ResponseEntity crearProducto(@RequestBody Producto producto) {
    return ResponseEntity.ok(productoService.guardar(producto));
}
```

**Código Frontend:**

```javascript
fetch("http://localhost:8080/productos", {
  method: "POST",
  headers: {
    "Content-Type": "application/json"
  },
  body: JSON.stringify(producto)
})
.then(response => response.json())
.then(nuevoProducto => {
  // Manejar la respuesta (e.g., actualizar la lista)
})
.catch(error => console.error(error));
```

---

### 2) Listar productos con Fetch()

**Código Backend:**

```java
@GetMapping
public ResponseEntity<List<Producto>> listarTodos() {
    return ResponseEntity.ok(productoService.listarTodos());
}
```

**Código Frontend:**

```javascript
fetch("http://localhost:8080/productos")
  .then(response => response.json())
  .then(productos => {
    mostrarProductosEnLaPantalla(productos);
  })
  .catch(error => console.error(error));
```

---

### 3) Actualizar productos con Fetch()

**Código Backend:**

```java
@PutMapping("/{id}")
public ResponseEntity actualizar(@PathVariable Long id, @RequestBody Producto producto) {
    return ResponseEntity.ok(productoService.actualizar(producto, id));
}
```

**Código Frontend:**

```javascript
fetch("http://localhost:8080/productos/1", {
  method: "PUT",
  headers: {
    "Content-Type": "application/json"
  },
  body: JSON.stringify(producto)
})
.then(response => response.json())
.then(productoActualizado => {
  // Manejar la respuesta (e.g., actualizar la lista)
})
.catch(error => console.error(error));
```

---

### 4) Eliminar productos con Fetch()

**Código Backend:**

```java
@DeleteMapping("/{id}")
public ResponseEntity eliminar(@PathVariable Long id) {
    productoService.eliminar(id);
    return ResponseEntity.noContent().build();
}
```

**Código Frontend:**

```javascript
fetch("http://localhost:8080/productos/1", {
  method: "DELETE",
  headers: {
    "Content-Type": "application/json"
  }
})
.then(response => {
  if (response.status === 204) {
    // Manejar la respuesta (e.g., actualizar la lista)
  } else {
    console.error("Error al eliminar el producto");
  }
})
.catch(error => console.error(error));
```

---

## Verificación del funcionamiento

### Verificación de Flujos

- Realiza pruebas con Postman para validar el funcionamiento de la API.
- Verifica en la base de datos que se crean, modifican o eliminan registros correctamente.
- Asegúrate de que los flujos de datos sean consistentes y que los errores se gestionen correctamente.

---

### Carga Inicial

1. Cargar aplicación y validar interfaz.
2. Verificar llamada `GET /productos`.
3. Confirmar visualización de productos.
4. Revisar imágenes y precios.

---

### Agregar al Carrito

1. Verificar botón “Agregar al carrito”.
2. Validar notificación de confirmación.
3. Comprobar actualización del contador.
4. Revisar productos en carrito.

---

### Actualización de Stock

1. Comprobar actualización del stock.
2. Verificar límites de stock.
3. Validar persistencia en backend.
4. Confirmar estado al recargar.

---

## Buenas prácticas de manejo de Errores en la Integración

### Error 404
Si un producto no se encuentra disponible, mostrar el mensaje “Producto no encontrado” al usuario.

### Error 500
Registrar el error en los logs del sistema y mostrar un mensaje genérico al usuario en el frontend.

### Errores de Formato
Asegurar que los nombres de los campos en la respuesta JSON coincidan exactamente con lo esperado por el frontend.

---

## Ajustando Formatos JSON y Validaciones

Si el frontend espera `"price"` y la API envía `"precio"`, podemos usar:

```java
public class Producto {
    @JsonProperty("price")
    private Double precio;
    // ...
}
```

---

## Materiales y Recursos Adicionales

- **Documentación Spring:** [Guía sobre CORS](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-cors)
- **MDN Web Docs:** [Documentación de fetch()](https://developer.mozilla.org/es/docs/Web/API/Fetch_API)
- **Tutoriales en Video:** Videos recomendados sobre integración de APIs REST con frontends HTML/JS.

---

## Ejercicio Práctico Obligatorio

### Situación inicial en TechLab

El cliente Sibelius está por lanzar su e-commerce.  
El frontend (HTML, CSS y JS) ya está casi listo, pero al conectarlo con la API del backend surgen errores CORS y de manejo de errores.

### Objetivos

1. Probar la configuración de CORS en el Backend con `@CrossOrigin`.
2. Manejar solicitudes a productos inexistentes (por ejemplo `GET /productos/9999`).
3. Mostrar el catálogo real en el Front refrescando la lista de productos.