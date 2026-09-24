# Sistema de Gestión de Biblioteca

API REST desarrollada con Java y Spring Boot para gestionar una biblioteca mediante datos JSON.

## Tecnologías

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- Git y GitHub

## Arquitectura por capas

- Controller
- Service
- Repository
- Entity

## Tablas

1. roles
2. usuarios
3. categorias
4. editoriales
5. autores
6. libros
7. libro_autor
8. ejemplares
9. prestamos
10. detalle_prestamo

Las tablas son generadas automáticamente desde las entidades Java mediante JPA e Hibernate.

## Configuración

Crear en MySQL una base de datos vacía:

CREATE DATABASE biblioteca_db;

Configurar la contraseña de MySQL en PowerShell:

$env:DB_PASSWORD="contraseña_mysql"

Ejecutar el proyecto:

.\mvnw.cmd spring-boot:run

## API REST

La API funciona en:

http://localhost:8080/api

Los datos se registran y consultan en formato JSON mediante Postman.

## Autor

Tineo Yupanqui Abiel Aurelio
