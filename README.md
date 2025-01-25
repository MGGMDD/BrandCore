BrandCore 
Test Java 2025 Capitole - Inditex 
---------------------------------
Aplicación/servicio que provea un servicio rest de consulta tal que:
Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena. Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar. Utiliza una arquitectura hexagonal y una base de datos en memoria basado en H2 para la persistencia de datos.

Tecnologías 
-----------
- Java 17
- Spring Boot
- JPA (Hibernate)
- H2 Database
- JUnit 5
- Mockito
- MapStruct
- OpenApi
- i18n

Configuración 
-------------
Se ha tenido en cuenta a la hora de la configuracion de H2 que pueda ser usada de forma automatica por los scripts de Fliway.
Los tests comparten H2 como base de datos para pruebas.
- Url servicio: http://localhost:8080/prices
- Consola h2: http://localhost:8080/h2-console
- User: maria
- Password: pass

Información de interés
----------------------
Se han incluido las colecciones postman en esta ubicacion 'src/main/resources/postman/BrandCore.postman_collection.json'


