
# 🌱 Clase 10 | Introducción a Spring Boot

---

## 🧭 Índice

1. ¿Qué es Spring Boot y por qué utilizarlo?
2. Creación de un proyecto Spring Boot desde cero.
3. Estructura básica de un proyecto Spring Boot.
4. Configuración inicial y dependencias necesarias.
5. Primeros pasos con Spring Boot.
6. Introducción a la Clase 11: Desarrollo de la API REST con Spring Boot.

---

## 🎯 Objetivos de la Clase

- **Comprender Spring y Spring Boot**  
  Conocer el ecosistema Spring y las ventajas de Spring Boot.

- **Crear un proyecto Spring Boot**  
  Aprender a iniciar un proyecto desde cero con Spring Initializr.

- **Estructura y configuración**  
  Familiarizarse con la estructura básica y configuración inicial.

- **Implementar un endpoint REST**  
  Dar los primeros pasos creando un endpoint REST simple.

---

## 🌼 Spring

### 💡 ¿Qué es Spring?
Spring es un **framework de aplicación de código abierto** para el desarrollo de aplicaciones **Java empresariales**.  
Su objetivo principal es **simplificar y agilizar el desarrollo**, promoviendo la **modularidad** y el **desacoplamiento** mediante la **inyección de dependencias (DI)**.

Esto permite que diferentes partes de una aplicación se desarrollen e integren de forma independiente, facilitando el **mantenimiento**, **las pruebas** y **la reutilización** del código.

---

### ⚙️ Spring Framework

#### 🧩 Base del Ecosistema
Proporciona la infraestructura fundamental para aplicaciones Java robustas.

#### 💉 Inyección de Dependencias
Facilita la gestión de componentes y sus dependencias.

#### 🧠 Programación AOP
Soporta la **Programación Orientada a Aspectos** para una modularidad avanzada.

---

## 🌐 Ecosistema Spring

- **Spring MVC** → Creación de aplicaciones web y controladores HTTP.
- **Spring Data** → Simplifica el acceso a datos y repositorios CRUD.
- **Spring Security** → Proporciona autenticación y autorización.
- **Otros proyectos:** Spring Cloud, Spring Batch, Spring Integration, entre otros.

---

## 🚀 Spring Boot

### 🔍 ¿Qué es Spring Boot?
Spring Boot **simplifica y acelera** el desarrollo de aplicaciones Spring, eliminando configuraciones complejas.  
Su principio es **“convención sobre configuración”**, y su sistema de **autoconfiguración** ajusta la aplicación automáticamente según las dependencias agregadas.

### 🌟 Beneficios de Spring Boot

| Beneficio | Descripción |
|------------|-------------|
| ⚙️ **Servidor Integrado** | No requiere despliegue externo, se ejecuta con `java -jar`. |
| ☕ **Opciones de Servidor** | Tomcat por defecto, pero soporta Jetty o Undertow. |
| ⚡ **Desarrollo Ágil** | Permite probar la API inmediatamente después de un commit. |

---

## 🧱 Creación de un Proyecto Spring Boot

1. **🌐 Spring Initializr:** [https://start.spring.io](https://start.spring.io)
2. **⚙️ Configuración:** Elegir versión, nombre, lenguaje y dependencias.
3. **⬇️ Descarga:** Obtener el proyecto generado.
4. **💻 IDE:** Abrirlo en IntelliJ, Eclipse o VS Code.

---

## 📁 Estructura Básica del Proyecto

| Directorio / Archivo | Descripción |
|------------------------|--------------|
| `src/main/java` | Código fuente del backend |
| `src/main/resources` | Archivos de configuración |
| `src/test` | Pruebas unitarias e integración |
| `pom.xml` o `build.gradle` | Dependencias y configuración |
| `application.properties` | Configuración principal de la app |

Ejemplo de clase principal:
```java
@SpringBootApplication
public class TechlabApplication {
    public static void main(String[] args) {
        SpringApplication.run(TechlabApplication.class, args);
    }
}
```

---

## 📦 Dependencias Comunes

- **spring-boot-starter-web** → Para crear endpoints REST y apps web.
- **spring-boot-starter-data-jpa** → Acceso a datos con JPA.
- **spring-boot-starter-security** → Seguridad en el backend.
- **spring-boot-starter-test** → Pruebas unitarias e integración.

---

## ⚙️ Configuración Inicial

### 📝 application.properties
```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
```

### 🧾 application.yml
```yaml
server:
  port: 8080
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydatabase
```

---

## 🧩 Perfiles de Configuración

| Entorno | Descripción |
|----------|--------------|
| **Desarrollo** | Configuración para entorno local. |
| **Pruebas** | Configuración para pruebas automatizadas. |
| **Producción** | Configuración optimizada para despliegue. |

---

## 🌍 Primeros Pasos con Spring Boot

Ejemplo de endpoint REST:
```java
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @GetMapping
    public List listarProductos() {
        return Arrays.asList(new Producto("Café", 250.0, 100));
    }
}
```

---

## 💉 Inyección de Dependencias

La **Inyección de Dependencias (DI)** desacopla clases, haciendo el código más flexible y fácil de probar.

### 🧠 Ejemplo
```java
@Service
public class ProductoService { ... }

@RestController
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
}
```

---

## 📚 Materiales y Recursos Adicionales

- 📘 [Documentación Oficial](https://spring.io/projects/spring-boot)
- 🎥 [Tutorial en YouTube](https://youtu.be/kFIvslQQZ9k?si=vHPRSt4l9iH-TecE)
- 💬 Comunidad Spring → Foros y grupos de discusión.

---

## 💭 Preguntas para Reflexionar

1. 🤔 ¿Cómo se integra Spring Boot con el ecosistema Spring para agilizar el desarrollo?
2. ⚙️ ¿Qué ventajas ofrece el arranque rápido y el servidor embebido?
3. 🚀 ¿Cómo reduce la autoconfiguración la carga cognitiva del equipo en TechLab?

---

## 🧪 Ejercicios Prácticos

### 🔹 Situación Inicial
Silvia, la Product Owner, quiere exponer la lógica del backend a un frontend o clientes externos.  
Matías y Sabrina descubren que **Spring Boot** acelera la creación de **APIs REST** robustas, seguras y escalables.

Con Spring Boot, pueden:
- Arrancar un servidor en minutos.
- Exponer endpoints REST.
- Conectarse a una base de datos.
- Agregar seguridad progresivamente.

---

### 🧠 Ejercicio Práctico Obligatorio 1

**Objetivo:** Crear un proyecto básico con Spring Boot.  
Pasos:

1. Crear el proyecto en **Spring Initializr**.
2. Seleccionar **Spring Web** y **Spring Data JPA**.
3. Descargar e importar en tu IDE.
4. Crear un endpoint GET `/hello` que devuelva un mensaje simple.
5. (Opcional) Cambiar el puerto:
   ```properties
   server.port=9090
   ```
   Verificar en [http://localhost:9090](http://localhost:9090)

---

### 🧠 Ejercicio Práctico Obligatorio 2

**Inyectar Dependencias:**

1. Crear un `ProductoService` que devuelva una lista de productos.
2. Inyectarlo en `ProductoController` usando `@Autowired`.
3. Usar `productoService` para servir los datos al endpoint.