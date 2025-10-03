# Laboratorio03 — Login + CRUD Usuarios (Spring Boot + JPA + PostgreSQL + Thymeleaf)

Proyecto MVC con **login contra BD**  y **CRUD completo** sobre la tabla `usuarios`.

## Requisitos
- JDK 17 o 21
- Maven (o wrapper `mvnw`)
- PostgreSQL 14+ (o superior)

## Configuración
1. Duplica el archivo de ejemplo:
   - Copia `src/main/resources/application-example.properties` a  
     `src/main/resources/application.properties`
2. Ajusta tus credenciales de BD en `application.properties`.

**Ejemplo de `application.properties`:**
```properties
spring.application.name=laboratorio03
spring.datasource.url=jdbc:postgresql://localhost:5432/seguridaddb
spring.datasource.username=postgres
spring.datasource.password=TU_CLAVE

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=9000
spring.thymeleaf.cache=false
