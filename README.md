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

##

