# Inadvance Evaluation Project

## Descripción
Este proyecto es un sistema de gestión de usuarios desarrollado en Spring Boot. Proporciona funcionalidades para agregar usuarios y listar usuarios existentes. También incluye autenticación JWT y validación de datos.

## Requisitos
- Java 8
- Gradle 6.8.3

## Configuración del Proyecto

### Plugins Utilizados
```groovy
plugins {
    id 'java'
    id 'jacoco'
    id 'org.springframework.boot' version '2.3.1.RELEASE'
    id 'io.spring.dependency-management' version '1.0.9.RELEASE'
}
```
### Dependencias
```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-security'
    runtimeOnly 'com.h2database:h2'
    implementation 'io.jsonwebtoken:jjwt:0.9.1'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.mockito:mockito-core'
    implementation 'org.mapstruct:mapstruct:1.4.2.Final'
    annotationProcessor 'org.mapstruct:mapstruct-processor:1.4.2.Final'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'io.springfox:springfox-boot-starter:3.0.0'
    implementation 'com.fasterxml.jackson.core:jackson-databind'
    implementation 'com.fasterxml.jackson.core:jackson-annotations'
    implementation 'com.fasterxml.jackson.core:jackson-core'
}
```

### Gradle
```groovy
  distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-6.8.3-bin.zip
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
```

### Base de Datos H2 y configuracion del JPA
```groovy
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=sa
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

### Swagger
http://localhost:8080/swagger-ui/

## Diagramas
El codigo del diagrama esta en el directorio /documentation/diagram

![Diagrama de Secuencia](https://www.plantuml.com/plantuml/png/bLFDRi8m3BxtAN9i3y2zXudzSDYa2GJb0IpYeOZGPBOBwzkl6H14bqtb4Yd-VlmbigSiGDBiRGORSQJMZ9I5GuqUVYxFhXPorYALQZ5VLMe2taoQ3k49Q9tTSA9gXNGm6tpTUrigmgrXGGf07eubVZR8ybBDYwp7lXYyW_UXPND3hrpQ8mhKA1KW59AD-iG3MAD1SBO7O_C0ZxSefrjHt6Mn0EQZ8nrTOk5EeqTB2BgzHlfJlaJls8YZjbJurNqvFxN_lEHAJ__Q1rZ6LA-tewp5T8mjraWWMBaTrkTiPp1jAO4u93x30S-6Gw86kWxL8UDq6g9kSF8e6pP2IsJlQiPE-hjFObrIcYiU9QMwa6Qr66d7RfVtf4KsnLg7BVq6)

##Ejecución de la Aplicación
### Compilar y Ejecutar
Para compilar y ejecutar la aplicación, usa los siguientes comandos de Gradle:
```groovy
./gradlew clean build
./gradlew bootRun
```

### Acceder a la Consola H2
Para acceder a la consola H2, abre un navegador web y navega a:
```groovy
http://localhost:8080/h2-console
```

### Ver la Documentación de Swagger
Para ver la documentación generada por Swagger, abre un navegador web y navega a:
```groovy
http://localhost:8080/swagger-ui/
```

### Ejecución de Pruebas
Para ejecutar las pruebas, usa el siguiente comando de Gradle:
```groovy
./gradlew test
```


### Generar el Reporte de Cobertura
Para generar el reporte de cobertura de código con Jacoco, usa el siguiente comando de Gradle:
```groovy
./gradlew jacocoTestReport
```

