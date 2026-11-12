# Mi Cancha - Backend & Base de Datos

Repositorio oficial del backend y la estructura de base de datos para **Mi Cancha**, 
una plataforma web dedicada a centralizar, consultar y gestionar la reserva de espacios 
deportivos de manera rápida y eficiente.

---

## Tecnologías y Herramientas

* **Lenguaje:** Java 21 (JDK 21)
* **Gestor de dependencias y compilación:** Gradle
* **Base de datos:** MySQL 8.0
* **Framework Backend (Próxima fase):** Spring Boot
* **Control de versiones:** Git & GitHub (gestionado con Fork)

---

## Estructura del Proyecto según los requisitos

```text
MiCanchaBackend/
├── data-base/
│   ├── modelo_relacional.jpg      # Diagrama Entidad-Relación de la base de datos
│   ├── 01_schema_mi_cancha.sql    # Script DDL de creación de base de datos y tablas
│   └── 02_datos_muestra.sql       # Script DML con datos iniciales (5 registros por tabla)
├── gradle/                        # Archivos de configuración del wrapper de Gradle
├── src/                           # Código fuente del proyecto en Java
├── build.gradle                   # Configuración de dependencias y compilación
└── README.md                      # Documentación principal del repositorio
```

---

## Modelo de Base de Datos

La base de datos **`mi_cancha_db`** está diseñada bajo un modelo relacional 
normalizado compuesto por 5 entidades principales:

1. **`roles`:** Define los niveles de acceso dentro de la plataforma (`CLIENTE`, `ADMIN`, `PROPIETARIO`, `MODERADOR`, `INVITADO`).
2. **`usuarios`:** Almacena la información de registro, credenciales y rol asignado a cada usuario.
3. **`deportes`:** Catálogo de disciplinas deportivas disponibles (Fútbol, Baloncesto, Fútbol Americano, Volleyball, Tenis).
4. **`canchas`:** Inventario de escenarios deportivos con su ubicación, tarifa por hora, estado de disponibilidad y recursos visuales.
5. **`reservas`:** Registro transaccional que vincula a un usuario con una cancha en una fecha y franja horaria específica.

---

## Equipo de Desarrollo - Grupo 1

Proyecto desarrollado de forma colaborativa para la gestión integral de reservas deportivas.

* **Repositorio Frontend:** [https://github.com/Juensi9Mora/Proyecto-Final-Grupo1.git]  (https://mi-cancha-g1.vercel.app)
