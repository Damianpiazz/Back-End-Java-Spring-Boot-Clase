# Clase 12 \| Integración con Base de Datos MySQL

## Índice

### Clase 12 \| Integración con Base de Datos MySQL

-   Introducción a bases de datos relacionales y MySQL.
-   Instalación y configuración de MySQL y Workbench.
-   Creación de la base de datos para el proyecto.
-   Conexión de Spring Boot con MySQL usando Spring Data JPA.
-   Mapeo de entidades y relaciones básicas.

### Clase 13 \| Operaciones CRUD con Base de Datos

-   Creación de interfaces Repository.
-   Implementación de operaciones CRUD utilizando JPA Repository.
-   Inyección de dependencias (@Autowired).
-   Refactorización de controladores y servicios para usar la base de
    datos.
-   Pruebas de funcionalidad con datos reales.

------------------------------------------------------------------------

## Objetivos de la Clase

-   **Comprender bases de datos relacionales:** Entender el concepto y
    la utilidad de MySQL en proyectos empresariales.
-   **Instalar y configurar MySQL:** Preparar el entorno de base de
    datos para nuestro proyecto.
-   **Mapear entidades:** Definir la entidad Producto y generar la tabla
    correspondiente.
-   **Conectar Spring Boot con MySQL:** Utilizar Spring Data JPA para la
    integración.

------------------------------------------------------------------------

## Bases de datos relacionales

### Introducción a Bases de Datos Relacionales

Las bases de datos relacionales son sistemas de gestión de bases de
datos (SGBD) que almacenan y organizan datos en tablas relacionadas
entre sí. Cada tabla tiene filas (registros) que representan datos
individuales y columnas (atributos) que definen los tipos de datos.

**Ventaja:**\
Capacidad de conectar diferentes tablas mediante claves, lo que permite
realizar consultas eficientes y complejas sobre datos relacionados. Esto
facilita la gestión de información grande y compleja manteniendo la
integridad y precisión de los datos.

Ejemplos comunes de bases de datos relacionales incluyen **MySQL**,
**PostgreSQL**, **Oracle**, **Microsoft SQL Server**, y **DB2**.

------------------------------------------------------------------------

## Conceptos Clave de Bases de Datos

-   **Tablas:** Contienen registros de un tipo de entidad (ej.
    producto).
-   **Llaves Primarias:** Identifican unívocamente cada fila en una
    tabla.
-   **Relaciones:** Vinculan datos entre tablas (ej. productos y
    categorías).

------------------------------------------------------------------------

## MySQL y Workbench: Herramientas esenciales

### MySQL

Un sistema de gestión de bases de datos (SGBD) relacional de código
abierto, popular por su confiabilidad, rendimiento y facilidad de uso.

### Workbench

Una herramienta gráfica para administrar bases de datos MySQL, que
permite crear, editar y consultar tablas, ejecutar consultas SQL y
administrar usuarios.

------------------------------------------------------------------------

## Instalación de MySQL

### Descargar MySQL Community Server

Visitar <https://dev.mysql.com/downloads/> y seleccionar la versión
adecuada para tu sistema operativo.

### Instalar MySQL

Seguir el asistente de instalación y configurar la contraseña para el
usuario root.

### Verificar instalación

Asegurarse de que el servicio MySQL esté corriendo en el sistema.

------------------------------------------------------------------------

## Instalación de MySQL Workbench

1.  Descargar MySQL Workbench desde el sitio oficial.\
2.  Instalar la herramienta.\
3.  Configurar la conexión con el servidor MySQL local.

------------------------------------------------------------------------

## Creación de la Base de Datos

Ejecuta estos comandos en **MySQL Workbench**:

``` sql
CREATE DATABASE techlabdb;
USE techlabdb;
```

------------------------------------------------------------------------

## Conexión de Spring Boot con MySQL

Conectar Spring Boot a MySQL es fundamental para habilitar la
persistencia de datos.

### Dependencias en `pom.xml`

Agregar:

``` xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

### Configuración en `application.properties`

``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/techlabdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> 🔒 Reemplazá `TU_CONTRASEÑA` con la contraseña real de tu base de
> datos.

------------------------------------------------------------------------

## Entidades en Java: Mapeando objetos a la base de datos

``` java
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Double precio;
    private Integer cantidadEnStock;
    // getters y setters
}
```

------------------------------------------------------------------------

## Verificación de la Creación de Tablas

1.  Ejecutar la aplicación con:

    ``` bash
    mvn spring-boot:run
    ```

2.  Verificar en MySQL Workbench con:

    ``` sql
    SHOW TABLES;
    ```

3.  Confirmar que la tabla `producto` fue creada correctamente.

------------------------------------------------------------------------

## Importancia de la Sincronización

-   **Coherencia:** Evita discrepancias entre el código y la base.
-   **Mantenibilidad:** Facilita la evolución del esquema de datos.
-   **Rendimiento:** Previene errores y optimiza las operaciones.

------------------------------------------------------------------------

## Materiales y Recursos Adicionales

-   [Documentación MySQL](https://dev.mysql.com/doc/)
-   [Spring Boot
    Reference](https://docs.spring.io/spring-boot/docs/current/reference/html/)
-   [Spring Data JPA
    Reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)

------------------------------------------------------------------------

## Ejercicio Práctico Obligatorio

### Verificación de entidad y tabla

**Objetivo:** Confirmar que la entidad Producto se mapea correctamente.

**Tareas:** 1. Configurar dependencias (`mysql-connector-j` y
`spring-boot-starter-data-jpa`). 2. Definir clase `Producto` con
anotaciones `@Entity`, `@Table`, `@Id`, `@GeneratedValue`. 3. Ejecutar y
verificar que la tabla `producto` exista en la base `techlabdb`.

------------------------------------------------------------------------

### Customización de la entidad

**Objetivo:** Agregar un nuevo atributo y observar el impacto en la base
de datos.

**Tareas:** 1. Agregar `String categoria` en la clase `Producto`. 2.
Ejecutar nuevamente la aplicación (`ddl-auto=update`). 3. Verificar que
la columna `categoria` fue creada. 4. Comentar sobre la importancia de
mantener sincronizado el modelo con la base.

------------------------------------------------------------------------

## Preguntas para Reflexionar

1.  **Ventajas de las anotaciones:** ¿Por qué es conveniente definir las
    entidades con anotaciones como `@Entity` y `@Table`?
2.  **ddl-auto=update:** ¿Qué ventajas ofrece al inicio del proyecto y
    qué riesgos implica en producción?
3.  **Persistencia de datos:** ¿Cómo ayuda la persistencia en la base a
    resolver la pérdida de datos?

------------------------------------------------------------------------

## Consejos para el Desarrollo

-   **Mantén el Código Limpio:** Usa buenas prácticas.
-   **Usa Control de Versiones:** Git para rastrear cambios.
-   **Prueba Regularmente:** Realiza pruebas unitarias e integración.
