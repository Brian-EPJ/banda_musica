# 🎸 KolossalRemains - Band Website

[![Deployed on Railway](https://img.shields.io/badge/Deployed%20on-Railway-blueviolet)](https://bandamusica-production.up.railway.app/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf&logoColor=white)](https://www.thymeleaf.org/)

> Sitio web oficial de la banda de Brutal Death Metal chilena **KolossalRemains**

## 📋 Descripción

Aplicación web desarrollada con **Spring Boot** que presenta la información oficial de la banda de metal extremo KolossalRemains, formada en 2020 en Chile. El sitio proporciona información detallada sobre la banda, sus miembros actuales, historia y formas de contacto.

KolossalRemains es conocida por su sonido brutal que mezcla death metal moderno con atmósferas oscuras y épicas, creando una experiencia sonora devastadora.

## ✨ Características

- 🏠 **Página Principal**: Información completa sobre la banda, su historia y filosofía musical
- 👥 **Perfil de Miembros**: Detalles de cada integrante de la banda con su rol e instrumento
- 📧 **Contacto**: Formulario para comunicarse directamente con la banda
- 🎨 **Diseño Temático**: Interfaz oscura acorde a la estética del metal extremo
- 📱 **Responsive**: Adaptado para verse correctamente en dispositivos móviles y desktop
- 🗄️ **Gestión de Datos**: Almacenamiento persistente de información en MySQL

## 🚀 Demo en Vivo

Visita el sitio web en: [https://bandamusica-production.up.railway.app/](https://bandamusica-production.up.railway.app/)

## 🛠️ Tecnologías Utilizadas

### Backend
- **Java** - Lenguaje de programación principal
- **Spring Boot** - Framework para desarrollo de aplicaciones Java
- **Spring MVC** - Patrón Modelo-Vista-Controlador
- **Spring Data JPA** - Capa de persistencia
- **MySQL** - Sistema de gestión de base de datos relacional
- **Maven** - Gestión de dependencias y construcción del proyecto

### Frontend
- **Thymeleaf** - Motor de plantillas para Java
- **HTML5** - Estructura de las páginas
- **CSS3** - Estilos y diseño responsivo

### Deployment & DevOps
- **Railway** - Platform as a Service (PaaS) para despliegue
- **MySQL on Railway** - Base de datos en la nube

## 📁 Estructura del Proyecto

```
banda_musica/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/banda/musica/
│   │   │       ├── controller/      # Controladores MVC
│   │   │       ├── model/          # Entidades JPA
│   │   │       ├── repository/     # Repositorios de datos
│   │   │       ├── service/        # Lógica de negocio
│   │   │       └── BandaMusicaApplication.java
│   │   └── resources/
│   │       ├── templates/          # Plantillas Thymeleaf
│   │       ├── static/
│   │       │   └── images/        # Imágenes y recursos
│   │       └── application.properties  # Configuración
│   └── test/                 
├── pom.xml                         # Dependencias Maven
└── README.md                       # Este archivo
```

## 💻 Instalación y Configuración

### Prerrequisitos

- **Java JDK 17** o superior
- **Maven 3.6+** (o usar el Maven Wrapper incluido)
- **MySQL 8.0+** instalado localmente
- IDE recomendado: IntelliJ IDEA, Eclipse o VS Code con extensiones Java

### Instalación Local

1. **Clona el repositorio:**
```bash
git clone https://github.com/Brian-EPJ/banda_musica.git
cd banda_musica
```

2. **Configura la base de datos MySQL:**
```sql
CREATE DATABASE banda_musica;
CREATE USER 'banda_user'@'localhost' IDENTIFIED BY 'tu_password';
GRANT ALL PRIVILEGES ON banda_musica.* TO 'banda_user'@'localhost';
FLUSH PRIVILEGES;
```

3. **Configura las variables de entorno:**

Edita `src/main/resources/application.properties`:

```properties
# Configuración del servidor
server.port=8080

# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/banda_musica
spring.datasource.username=banda_user
spring.datasource.password=tu_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Configuración de Thymeleaf
spring.thymeleaf.cache=false
```

4. **Compila el proyecto:**
```bash
mvn clean install
```

5. **Ejecuta la aplicación:**
```bash
mvn spring-boot:run
```

O usando el Maven Wrapper:
```bash
./mvnw spring-boot:run
```

6. **Abre tu navegador en:** `http://localhost:8080`

## 🔧 Configuración para Producción (Railway)

### Variables de Entorno en Railway

Configura las siguientes variables en tu proyecto de Railway:

```env
SPRING_DATASOURCE_URL=jdbc:mysql://[railway-mysql-host]:[port]/railway
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=[railway-mysql-password]
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SERVER_PORT=8080
```

Railway detecta automáticamente tu `application.properties` y las variables de entorno sobreescriben la configuración local.

## 📦 Scripts Maven Disponibles

```bash
mvn spring-boot:run        # Inicia la aplicación en modo desarrollo
mvn clean install          # Limpia y construye el proyecto
mvn test                   # Ejecuta los tests
mvn package               # Genera el archivo JAR
mvn spring-boot:run -Dspring-boot.run.profiles=dev  # Ejecuta con perfil específico
```

## 🎭 Sobre KolossalRemains

**KolossalRemains** es una banda de Brutal Death Metal formada en 2020 en Chile 🇨🇱. Su sonido es un choque titánico entre riffs devastadores, baterías que retumban como maquinaria de guerra y voces que desgarran la frontera entre lo humano y lo primordial.

### Miembros Actuales (2020 - Presente)

- **Martin Castro** - Guitarra
- **Martin Parra** - Bajo
- **Matias Sepulveda** - Guitarra
- **Anibal Zuñiga** - Batería

### Filosofía Musical

La banda explora mundos en ruinas, mitologías olvidadas, conflictos internos y la eterna lucha entre destrucción y renacimiento, convirtiendo estas narrativas en un muro de sonido implacable.

> "Kolossal Remains no busca encajar: domina, impone y deja restos… restos colosales."


### Despliegue en Railway

1. Conecta tu repositorio de GitHub con Railway
2. Railway detecta automáticamente que es un proyecto Spring Boot
3. Configura las variables de entorno necesarias
4. Railway construirá y desplegará automáticamente tu aplicación
5. Conecta tu base de datos MySQL de Railway al proyecto

El comando de inicio por defecto:
```bash
java -jar target/banda_musica-0.0.1-SNAPSHOT.jar
```

## 🐛 Reportar Problemas

Si encuentras algún bug o tienes sugerencias, por favor abre un [Issue](https://github.com/Brian-EPJ/banda_musica/issues) en GitHub.
.

## 👤 Autor

**Brian EPJ**

- GitHub: [@Brian-EPJ](https://github.com/Brian-EPJ)
- Proyecto: [banda_musica](https://github.com/Brian-EPJ/banda_musica)


- **Sitio Web**: [https://bandamusica-production.up.railway.app/](https://bandamusica-production.up.railway.app/)
- **Contacto**: [/contacto](https://bandamusica-production.up.railway.app/contacto)

## 🙏 Agradecimientos

- A la banda **KolossalRemains** por permitir crear este sitio web
- A la comunidad de Spring Boot por el excelente framework
- A Railway por facilitar el deployment

---

⭐ **Si te gusta este proyecto, considera darle una estrella en GitHub**

💀🔥 **Metal desde el abismo** 🔥💀

*Desarrollado con ☕ y 🎸 por Brian EPJ*
