CREATE DATABASE mi_cancha;
USE mi_cancha;

-- Creación de tabla Roles
CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(150) NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(10) DEFAULT 'ACTIVO'
);

-- Creación de tabla Usuarios
CREATE TABLE usuarios (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    telefono VARCHAR(25),
    email VARCHAR(150) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    rol_id INT,
    FOREIGN KEY (rol_id) REFERENCES roles(id)
);

-- Creación de tabla Deportes
CREATE TABLE deportes (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(80) NOT NULL,
    descripcion VARCHAR(255)
);

-- Creación de tabla Ciudad
CREATE TABLE ciudades (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    pais VARCHAR(80) NOT NULL
);

-- Creación de tabla Canchas
CREATE TABLE canchas (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    precio_hora DECIMAL(10,2) NOT NULL,
    moneda VARCHAR(10) NOT NULL,
    activa VARCHAR(20) NOT NULL,
    ciudad_id INT,
    deporte_id INT,
    FOREIGN KEY (ciudad_id) REFERENCES ciudades(id),
    FOREIGN KEY (deporte_id) REFERENCES deportes(id)
);

-- Creación de tabla Reservas
CREATE TABLE reservas (
	id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_reserva DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    cantidad_horas INT NOT NULL,
    numero_jugadores INT,
    estado VARCHAR(25) NOT NULL,
    usuario_id INT,
    cancha_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (cancha_id) REFERENCES canchas(id)
);

-- Mostrar Tablas
SHOW TABLES;

-- Insertar datos Roles
SELECT * FROM roles;
INSERT INTO roles (nombre, descripcion, estado) VALUES
('ADMINISTRADOR', 'Gestiona la plataforma', 'INACTIVO'),
('PROPIETARIO', 'Administra sus canchas deportivas', 'INACTIVO'),
('CLIENTE', 'Consulta canchas y realiza reservas', 'ACTIVO');

-- Insertar datos Usuarios
SELECT * FROM usuarios;
INSERT INTO usuarios (nombre, telefono, email, contrasena, rol_id) VALUES
('Andrés Satoba', '3003456780', 'andres@example.com', 'hash_demo_001', 3),
('Yesid Hernandez', '3219876210', 'yesid@example.com', 'hash_demo_002', 3),
('Carolayn Ayala', '3124567890', 'carolayn@example.com', 'hash_demo_003', 3),
('Jennyfer Choque', '3045356020', 'jennyfer@example.com', 'hash_demo_004', 3),
('Christopher Caleb', '30298763245', 'caleb@example.com', 'hash_demo_005', 3);

-- Insertar datos Deportes
SELECT * FROM Deportes;
INSERT INTO deportes (nombre, descripcion) VALUES
('Tennis', 'Deporte de raqueta y de oposición que se juega en una pista rectangular dividida por una red, ya sea de manera individual o en parejas.'),
('Fútbol', 'Deporte de equipo en el que dos conjuntos de 11 jugadores compiten por introducir un balón en la portería rival.'),
('Baloncesto', 'Deporte de equipo que enfrenta a dos bandos de cinco jugadores cada uno, cuyo objetivo es introducir un balón en el aro del equipo contrario.'),
('Voleibol', 'Deporte de equipo en el que dos grupos de seis jugadores se enfrentan en una cancha rectangular dividida por una red central.'),
('Futsal', 'Deporte colectivo de ritmo rápido que se juega entre dos equipos de cinco jugadores.');

-- Insertar datos Ciudad
SELECT * FROM ciudades;
INSERT INTO ciudades (nombre, pais) VALUES
('Bogotá', 'Colombia'),
('Medellín', 'Colombia'),
('Lima', 'Perú'),
('Arequipa', 'Perú');

-- Insertar datos Canchas
SELECT * FROM canchas;
INSERT INTO canchas (nombre, direccion, precio_hora, moneda, activa, ciudad_id, deporte_id) VALUES
('Cancha El Salitre', 'Calle 63 # 59A - 06', 150000, 'COP', 'SI', 1, 1),
('Cancha Marbella', 'CRA 69 # 8 - 28', 90000, 'COP', 'SI', 1, 2),
('Cancha DeporGol', 'Calle Claudio Galeno N° 100', 90, 'PEN', 'SI', 4, 2),
('Cancha EL Paraiso', 'Calle 44 # 52 - 165', 60000, 'COP', 'SI', 2, 3),
('Cancha Elbowa', 'Av. Próceres cuadra 5, Santiago De Surco', 180, 'PEN', 'SI', 3, 3),
('Coliseo Arequipe', 'Av. Independencia con la Calle Condesuyos', 80, 'PEN', 'SI', 4, 4),
('Cancha Arena 7', 'Calle 6A # 78F - 25', 80000, 'COP', 'SI', 1, 5);

-- Insertar datos Reservas
SELECT * FROM reservas;
INSERT INTO reservas (fecha_reserva, hora_inicio, cantidad_horas, numero_jugadores, estado, usuario_id, cancha_id) VALUES
('2026-12-01', '09:00:00', 2, 22, 'CONFIRMADA', 1, 2),
('2026-12-02', '10:00:00', 1, 22, 'PENDIENTE', 4, 3),
('2026-12-03', '15:00:00', 3, 10, 'CONFIRMADA', 2, 7),
('2026-12-04', '16:00:00', 1, 10, 'PENDIENTE', 3, 4),
('2026-12-05', '18:00:00', 2, 12, 'FINALIZADA', 5, 6);

SELECT
    reservas.id,
    canchas.nombre AS cancha,
    canchas.precio_hora,
    reservas.cantidad_horas,
    (canchas.precio_hora * reservas.cantidad_horas) AS total
FROM reservas
INNER JOIN canchas
ON reservas.cancha_id = canchas.id;