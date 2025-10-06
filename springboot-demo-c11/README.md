# ☕ Clase 11 \| Desarrollo de la API REST con Spring Boot

------------------------------------------------------------------------

## 🧭 Índice

### Clase 11 \| Desarrollo de la API REST con Spring Boot

1.  Concepto de API REST y métodos HTTP\
2.  Creación de controladores (@RestController)\
3.  Manejo de rutas y endpoints básicos\
4.  Envío y recepción de datos en formato JSON\
5.  Implementación de operaciones CRUD en memoria

### Clase 12 \| Integración con Base de Datos MySQL

1.  Introducción a bases de datos relacionales y MySQL\
2.  Instalación y configuración de MySQL y Workbench\
3.  Creación de la base de datos para el proyecto\
4.  Conexión de Spring Boot con MySQL usando Spring Data JPA\
5.  Mapeo de entidades y relaciones básicas

------------------------------------------------------------------------

## 🎯 Objetivos de la Clase

### Comprender API REST

Entender el concepto, principios y uso de métodos HTTP para distintas
operaciones.

### Crear Controladores

Utilizar @RestController en Spring Boot para exponer endpoints.

### Configurar Rutas

Establecer rutas para operaciones CRUD básicas de productos.

### Trabajar con JSON

Aprovechar la serialización automática de Spring Boot para manejar datos
JSON.

------------------------------------------------------------------------

## 🌐 API REST

Una **API REST** (Representational State Transfer) es un estilo
arquitectónico para el diseño de servicios web que se basa en la
transferencia de representaciones de estado.\
Se caracteriza por su simplicidad, escalabilidad y uso de estándares web
como HTTP.

En una API REST, los **recursos** se identifican mediante URLs, y las
operaciones que se realizan sobre ellos se mapean a métodos HTTP
específicos (GET, POST, PUT, DELETE), permitiendo una interacción clara
y eficiente entre cliente y servidor.

------------------------------------------------------------------------

## ⚙️ Métodos HTTP en API REST

### GET

Se utiliza para **obtener o recuperar** un recurso específico.\
El servidor responde con la representación del recurso, generalmente en
formato JSON.

### POST

Se usa para **crear un nuevo recurso**.\
El servidor crea el recurso y responde con una confirmación o la
representación del nuevo recurso.

### PUT

Sirve para **actualizar un recurso existente**.\
Si el recurso no existe, PUT puede crearlo.

### DELETE

Se utiliza para **eliminar un recurso**.\
El servidor responde con una confirmación o un error si no puede
hacerlo.

------------------------------------------------------------------------

## 📡 Endpoints y Recursos

Un **endpoint** es una URL que representa un recurso o acción dentro de
la API.\
Ejemplo:

Método   Endpoint            Descripción
  -------- ------------------- --------------------------------
GET      `/productos`        Listar todos los productos
GET      `/productos/{id}`   Obtener un producto específico
POST     `/productos`        Crear un nuevo producto

------------------------------------------------------------------------

## 🧱 Creación de Controladores (@RestController)

En Spring Boot, un controlador REST se define con la anotación
**@RestController**.\
Los métodos de la clase devuelven el resultado directamente en el cuerpo
de la respuesta, usualmente en formato JSON.

### Anotaciones clave

-   `@RestController`
-   `@RequestMapping`
-   `@GetMapping`
-   `@PostMapping`

### Inyección de dependencias

Se usa `@Autowired` en el constructor o atributos para inyectar
servicios o repositorios.

#### Ejemplo de Controlador REST

``` java
@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarTodos();
    }
}
```

------------------------------------------------------------------------

## 🌍 Endpoints en Java

Un **endpoint** es una dirección URL específica que representa un
recurso o acción dentro de una API.

Ejemplo:

    /productos

Cuando una aplicación web envía una solicitud a este endpoint, la API
procesa la solicitud y responde con datos (por ejemplo, la lista de
productos).

### Ejemplo con PathVariable

``` java
@GetMapping("/{id}")
public Producto obtenerProducto(@PathVariable int id) {
    return productoService.obtenerPorId(id);
}
```

------------------------------------------------------------------------

## 💾 JSON: El Formato de Intercambio de Datos

**JSON (JavaScript Object Notation)** es un formato de texto ligero,
legible y ampliamente usado en APIs REST.

### Ejemplo de JSON

``` json
{
  "id": 1,
  "nombre": "Café de Colombia",
  "descripcion": "Café 100% Arábica de origen colombiano, con aroma intenso y sabor equilibrado.",
  "precio": 10.50,
  "stock": 100
}
```

### Ejemplo de uso en un controlador

``` java
@PostMapping
public Producto crearProducto(@RequestBody Producto nuevoProducto) {
    return productoService.guardar(nuevoProducto);
}
```

`@RequestBody` convierte el cuerpo de la solicitud en un objeto Java
(deserialización).\
La respuesta se convierte automáticamente en JSON (serialización).

------------------------------------------------------------------------

## 🧠 Service Layer (Capa de Servicio)

Un **Service** encapsula la lógica de negocio.\
Actúa entre el controlador y los datos, facilitando el mantenimiento y
la reutilización del código.

#### Ejemplo de ProductoService

``` java
@Service
public class ProductoService {
    private List<Producto> productos = new ArrayList<>();
    private int contadorId = 1;

    public List<Producto> listarTodos() {
        return productos;
    }

    public Producto guardar(Producto p) {
        p.setId(contadorId++);
        productos.add(p);
        return p;
    }
}
```

------------------------------------------------------------------------

## 💭 Preguntas para Reflexionar

-   ¿Cómo facilita Spring Boot la creación de endpoints REST comparado
    con una configuración manual?\
-   ¿Qué diferencia hay entre trabajar con datos en memoria y en una
    base de datos real?\
-   ¿Qué ventajas aporta el manejo de JSON como formato estándar de
    intercambio con el frontend?

------------------------------------------------------------------------

## 🧪 Ejercicio Práctico (Obligatorio)

### Situación

Silvia, la Product Owner, quiere que el frontend obtenga la lista de
productos desde el backend.\
Antes de conectar con una base de datos, es necesario construir la API
REST funcional.

### ✅ Tareas

1.  Implementar los siguientes endpoints:

    -   `GET /productos`
    -   `GET /productos/{id}`
    -   `POST /productos`
    -   `PUT /productos/{id}`
    -   `DELETE /productos/{id}`

2.  Probar los endpoints con **Postman** o **cURL**.

3.  Enviar una solicitud POST a `/productos` con un cuerpo JSON y
    verificar que se guarde en la lista.

------------------------------------------------------------------------