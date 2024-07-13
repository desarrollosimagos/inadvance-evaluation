-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS inadvance;

-- Usar la base de datos
USE inadvance;

-- Crear la tabla User
CREATE TABLE userInfo (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    lastLogin TIMESTAMP NULL DEFAULT NULL,
    token VARCHAR(255),
    isActive BOOLEAN NOT NULL
);

-- Crear la tabla Phone
CREATE TABLE Phone (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(255) NOT NULL,
    cityCode VARCHAR(10) NOT NULL,
    countryCode VARCHAR(10) NOT NULL,
    user_id CHAR(36),
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);

-- Añadir índice a la tabla User
CREATE INDEX idx_user_email ON User (email);
