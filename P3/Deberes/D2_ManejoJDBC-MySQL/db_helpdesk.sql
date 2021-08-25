CREATE DATABASE helpdesk;

USE helpdesk;

CREATE TABLE empleado(
	id_empleado INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    sueldo DECIMAL(8,2),
    fecha_ingreso DATE NOT NULL
);

INSERT INTO empleado(nombre, apellido, sueldo, fecha_ingreso)
	VALUES ('Carlos', 'Fernandez', 400.00, '2019-02-14');
INSERT INTO empleado(nombre, apellido, sueldo, fecha_ingreso)
	VALUES ('Andres', 'Rodriguez', 600.00, '2015-08-25');
INSERT INTO empleado(nombre, apellido, sueldo, fecha_ingreso)
	VALUES ('Karen', 'Casa', 800.00, '2000-06-05');