# Back-End-Java-Spring-Boot-Clase

Este repositorio contiene el desarrollo completo del **curso de Back-End con Java y Spring Boot**, desde la creación inicial del proyecto hasta la integración total con un frontend y la presentación final de los proyectos.

A lo largo de las clases 10 a 16, se abordaron los fundamentos del desarrollo backend moderno utilizando **Spring Boot**, **JPA**, **MySQL**, **Docker**, **Swagger** y buenas prácticas de arquitectura y diseño.

---

## 📚 Contenido por Clases

### 🧱 Clase 10 | Introducción a Spring Boot
- **Conceptos Clave:**
  - ¿Qué es **Spring Boot** y por qué es tan utilizado?
  - Ventajas frente a configuraciones manuales de Spring.
  - Creación de un proyecto Spring Boot desde cero (Spring Initializr).
  - Estructura básica del proyecto: `controller`, `service`, `repository`, `model`.
  - Configuración inicial en el archivo `application.properties`.
  - Agregado de dependencias esenciales: `spring-boot-starter-web`, `spring-boot-starter-test`.
- **Resultado:** Proyecto base funcional con servidor embebido **Tomcat** corriendo en el puerto 8080 o personalizado (por ejemplo, 9090).

---

### ⚙️ Clase 11 | Desarrollo de una API REST
- **Aprendizajes principales:**
  - Qué es una **API REST** y cómo funcionan los métodos HTTP (`GET`, `POST`, `PUT`, `DELETE`).
  - Creación de **controladores** con `@RestController` y mapeo de rutas con `@RequestMapping`.
  - Envío y recepción de datos en formato **JSON**.
  - Implementación de operaciones CRUD **en memoria** (sin base de datos).
  - Validación básica de entradas y manejo de respuestas HTTP.
- **Resultado:** API REST completamente funcional simulando datos desde una lista en memoria.

---

### 🗄️ Clase 12 | Conexión con Base de Datos (MySQL)
- **Nuevos conceptos y herramientas:**
  - Introducción a bases de datos relacionales y SQL.
  - Instalación y configuración de **MySQL** y **Workbench**.
  - Creación de la base de datos del proyecto.
  - Conexión de Spring Boot con MySQL usando **Spring Data JPA**.
  - Configuración de credenciales y propiedades en `application.properties`.
  - Mapeo de entidades (`@Entity`) y relaciones (`@OneToMany`, `@ManyToOne`).
- **Resultado:** La API ahora persiste datos en una base real, permitiendo almacenar, consultar, modificar y eliminar registros.

---

### 🧩 Clase 13 | CRUD con Base de Datos y JPA Repository
- **Temas cubiertos:**
  - Creación de interfaces `Repository` que extienden `JpaRepository`.
  - Implementación de operaciones CRUD utilizando JPA.
  - Inyección de dependencias mediante `@Autowired`.
  - Refactorización de controladores y servicios para usar repositorios.
  - Pruebas de endpoints con **Postman**.
- **Resultado:** CRUD completo persistente con MySQL, estructura modular siguiendo el patrón **Controller → Service → Repository**.

---

### 🌐 Clase 14 | Integración del Backend con el Frontend
- **Objetivos alcanzados:**
  - Configuración de **CORS** para permitir comunicación con el frontend (React / Next.js).
  - Consumo de endpoints desde el frontend con **Axios**.
  - Pruebas integrales de la aplicación full stack.
  - Manejo de errores y validaciones entre backend y frontend.
  - Buenas prácticas de serialización y manejo de DTOs.
- **Resultado:** Sistema completo conectado, donde el frontend interactúa directamente con la API REST.

---

### 🧰 Clase 15 | Contenedores, Documentación y Buenas Prácticas
- **Nuevas herramientas introducidas:**
  - Introducción a **Docker** y **Docker Compose**.
  - Creación de contenedor para **MySQL** con persistencia de datos.
  - Despliegue del backend en un contenedor Spring Boot.
  - Uso de **H2 Database** para pruebas rápidas y entornos de desarrollo.
  - Integración y documentación con **Swagger UI** (`springdoc-openapi`).
  - Organización del proyecto siguiendo patrones de diseño y arquitectura limpia:
    - **DTOs (Data Transfer Objects)**
    - **Capas desacopladas** (`Controller`, `Service`, `Repository`)
    - Buenas prácticas de naming y empaquetado.

- **Resultado:** BDD dockerizada y con datos persistente y documentación visual de la API disponible en Swagger (`/swagger-ui/index.html`).

---

### 🚀 Clase 16 | Presentación de Proyectos Finales
- **Actividades principales:**
  - Presentación de proyectos por parte de los alumnos.
  - Demostración del backend integrado con el frontend.
  - Revisión de código, corrección en vivo y feedback del profesor.
  - Discusión de buenas prácticas y soluciones implementadas.
  - Reflexión sobre el proceso completo de desarrollo full stack.

- **Temas complementarios:**
  - Introducción a posibles **caminos profesionales**: DevOps, Cloud, Microservicios, Seguridad, Bases de Datos Modernas e Inteligencia Artificial.
  - Herramientas vistas: **Swagger, Docker, JPA, H2, Spring Boot, Axios, Next.js**.
  - Recomendaciones para continuar el aprendizaje: CI/CD, Arquitectura de Microservicios, Kubernetes, Monitoreo y Observabilidad.

---

## 🧠 Tecnologías Aprendidas
| Categoría | Tecnologías / Conceptos |
|------------|-------------------------|
| Backend | Java, Spring Boot, Spring Web, Spring Data JPA |
| Base de Datos | MySQL, H2 (in-memory), JPA, Hibernate |
| API REST | CRUD, DTOs, Controladores, JSON, Swagger UI |
| DevOps | Docker, Docker Compose |
| Frontend (Integración) | Axios, Next.js / React |
| Diseño y Arquitectura | Patrón MVC, Inyección de Dependencias, Servicios y Repositorios |
| Documentación | Swagger / OpenAPI |
| Buenas Prácticas | Naming, Modularización, Testing con Postman |

---

## 🧭 Próximos Pasos
- Implementar autenticación con **Spring Security** y **JWT**.
- Desplegar la API en un entorno cloud (AWS / Render / Railway).
- Implementar CI/CD con GitHub Actions o Jenkins.
- Agregar monitoreo y logging estructurado.

---

## 🎓 Conclusión
Este curso consolidó las bases de desarrollo **Back-End profesional con Java y Spring Boot**, integrando conceptos fundamentales del ecosistema moderno: bases de datos, APIs REST, despliegue con Docker y documentación con Swagger.  
Los estudiantes culminaron el proceso con un **proyecto funcional e integrado**, siguiendo estándares de la industria y aplicando buenas prácticas de arquitectura.

---
