-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS ProductosBase;
USE ProductosBase;

-- Tabla de productos
CREATE TABLE IF NOT EXISTS producto (
                                        id_producto INT AUTO_INCREMENT PRIMARY KEY,
                                        nombre_producto VARCHAR(255) NOT NULL,
    precio_unitario DOUBLE NOT NULL
    );

-- Tabla de facturas
CREATE TABLE IF NOT EXISTS factura (
                                       id_factura INT AUTO_INCREMENT PRIMARY KEY,
                                       fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                       id_producto INT,
                                       cantidad INT,
                                       total DOUBLE,
                                       FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
    );
