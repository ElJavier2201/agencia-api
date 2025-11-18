# API - Agencia de Autos 

Este proyecto es el **backend (API REST)** para el sistema de gestión de una agencia de autos. Está construido en Java utilizando el framework Spring Boot y sirve como el cerebro central para manejar toda la lógica de negocio y los datos.

Esta API provee la información consumida por dos clientes:
1.  **Portal Web de Clientes:** Un sitio web (servido desde este mismo proyecto) donde los visitantes pueden ver el catálogo, cotizar y agendar servicios.
2.  **Aplicación de Escritorio (Swing):** `[Link a tu repositorio AGENCIAAUTOS]` - La herramienta interna para Gerentes y Vendedores (gestión, ventas, reportes).

---

##  Características Principales

* **Catálogo de Vehículos:** Sirve la lista de vehículos disponibles (`/api/vehiculos/catalogo`) y detalles de autos individuales (`/api/vehiculos/{id}`).
* **Portal de Cliente:**
    * Autenticación de clientes (Login).
    * Visualización de estado de cuenta (ventas financiadas y desglose de pagos).
* **Simulación de Cotización:** Endpoint (`/api/cotizar/simular`) para calcular pagos mensuales de un financiamiento.
* **Gestión de Servicios:**
    * Muestra una lista de servicios de mantenimiento y técnicos (`/api/servicios`).
    * Permite agendar citas de servicio (`/api/citas/agendar`).
* **Frontend Integrado:** Sirve el portal web del cliente (`catalogo.html`, `servicios.html`) y las imágenes directamente desde la carpeta `static`.
* **Seguridad:** Hashing de contraseñas de vendedores y clientes usando **jbcrypt**.
* **Gestión de Conexiones:** Utiliza **HikariCP** para un manejo eficiente del pool de conexiones a la base de datos.

---

## Stack Tecnológico

* **Backend:** Java (JDK 21+)
* **Framework:** Spring Boot
* **Base de Datos:** MySQL
* **Build Tool:** Maven

---

## Guía de Instalación y Ejecución Local

Para ejecutar este proyecto en tu máquina local, sigue estos pasos:

### 1. Prerrequisitos
* Tener instalado un JDK (Java Development Kit) versión 21 o superior.
* Tener un servidor MySQL ejecutándose (ej. desde XAMPP o MySQL Workbench).
* Haber configurado la variable de entorno `JAVA_HOME`.

### 2. Configurar la Base de Datos
1.  Asegúrate de que tu servidor MySQL esté encendido.
2.  Crea una base de datos llamada `agencia_autos`.
3.  Ejecuta el script SQL (`agencia_autos_schema.sql` - *debes añadir este archivo a tu repo*) para crear todas las tablas y datos de ejemplo.

### 3. Configurar Credenciales
Este proyecto usa un archivo `db.properties` para la conexión. Este archivo está ignorado por Git por seguridad.

1.  Ve a `src/main/resources/`.
2.  **Crea** un nuevo archivo llamado `db.properties`.
3.  Añade tu configuración de base de datos local:

    ```properties
    # Conexión MySQL
    db.url=jdbc:mysql://localhost:3306/agencia_autos
    db.driver=com.mysql.cj.jdbc.Driver
    db.username=root
    db.password=220105
    
    # Pool de Conexiones (HikariCP)
    db.pool.maximumPoolSize=10
    db.pool.minimumIdle=2
    # ... (puedes copiar el resto desde db.properties.example si lo creas)
    ```

### 4. Ejecutar la Aplicación

Puedes ejecutar la aplicación de dos maneras:

**Opción A: Desde tu IDE (Recomendado para desarrollo)**
1.  Abre el proyecto en tu IDE (IntelliJ).
2.  Espera a que Maven descargue todas las dependencias del `pom.xml`.
3.  Encuentra el archivo `src/main/java/com/agencia/api/ApiApplication.java` y ejecútalo (clic derecho > Run).

**Opción B: Desde la Terminal (Como un servidor)**
1.  Abre una terminal (CMD o PowerShell) en la carpeta raíz del proyecto `api`.
2.  Empaqueta la aplicación:
    ```bash
    .\mvnw.cmd package
    ```
3.  Ejecuta el archivo `.jar` generado:
    ```bash
    java -jar target/api-0.0.1-SNAPSHOT.jar
    ```

### 5. Acceder al Portal
Una vez que el servidor esté corriendo (verás `Tomcat started on port 8080...` en la consola), abre tu navegador y ve a:

* **Portal Web:** `http://localhost:8080/catalogo.html`
* **API (Datos):** `http://localhost:8080/api/vehiculos/catalogo`

---

##  Endpoints de la API (Ejemplos)

* `GET /api/vehiculos/catalogo`: Obtiene la lista de vehículos disponibles.
* `GET /api/vehiculos/{id}`: Obtiene los detalles de un vehículo específico.
* `GET /api/marcas`: Obtiene la lista de todas las marcas.
* `GET /api/servicios`: Obtiene la lista de servicios de mantenimiento.
* `GET /api/cotizar/simular`: Simula una cotización.
* `POST /api/clientes/login`: Autentica a un cliente.
* `GET /api/clientes/{id}/ventas-financiadas`: Obtiene las ventas con financiamiento de un cliente.
* `POST /api/citas/agendar`: Agenda una nueva cita de servicio.