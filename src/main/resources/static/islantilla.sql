DROP DATABASE IF EXISTS islantilla_spring;
CREATE DATABASE IF NOT EXISTS islantilla_spring;

USE islantilla_spring;
CREATE TABLE clientes
(
	nif VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    edad TINYINT NOT NULL,
    sexo TINYINT NOT NULL,
    PRIMARY KEY pk_clientes (nif)
);

CREATE TABLE reservas
(
	hab TINYINT NOT NULL,
    entrada DATE NOT NULL,
    nif VARCHAR(50) NOT NULL,
    precio DECIMAL (5,2) NOT NULL,
    PRIMARY KEY pk_reservas (hab, entrada),
    FOREIGN KEY fk_reservas (nif) REFERENCES clientes (nif)
);

-- Vamos a introducir datos
INSERT INTO clientes
VALUES ("12345678M", "Iván Rodríguez", 47, 0);

INSERT INTO reservas
VALUES (120, "2024-03-28", "12345678M", 75.50),
(118, "2024-03-23", "12345678M", 110.65);

SELECT * FROM clientes;
SELECT * FROM reservas;

