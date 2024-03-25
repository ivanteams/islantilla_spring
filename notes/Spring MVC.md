---
title: Spring MVC
created: '2023-12-16T10:59:17.473Z'
modified: '2024-03-25T12:38:16.606Z'
---

# Spring MVC
--------------

[//]: # (version: 1.0)
[//]: # (author: Iván Rodríguez)
[//]: # (date: 2023-12-16)



 # Tabla de contenidos
- [Spring MVC](#spring-mvc)
- [Tabla de contenidos](#tabla-de-contenidos)
  - [Introducción](#introducción)
  - [Instalación](#instalación)
  - [Hola Mundo](#hola-mundo)
  - [CRUD MySQL](#crud-mysql)
    - [Estructura del Proyecto](#estructura-del-proyecto)
    - [Consulta Genérica](#consulta-genérica)
    - [Crear BBDD y Probar](#crear-bbdd-y-probar)
    - [Operaciones CRUD](#operaciones-crud)
    - [Subapartado 2.1](#subapartado-21)
  - [Capitulo 3 - Proyecto Completo](#capitulo-3---proyecto-completo)
    - [Creación del Proyecto](#creación-del-proyecto)
    - [Definición de modelos](#definición-de-modelos)
    - [Gestión de Clientes](#gestión-de-clientes)
    - [Gestión de Reservas](#gestión-de-reservas)
    - [Consultas Adicionales](#consultas-adicionales)
  - [Capitulo 4 - Swagger](#capitulo-4---swagger)
  - [Capitulo 5 - Angular](#capitulo-5---angular)

<div style="page-break-after: always;"></div>


## Introducción
[Tabla de contenidos](#tabla-de-contenidos)

- Recurso Principal: 
  - https://www.uv.es/grimo/teaching/SpringMVCv4PasoAPaso/index.html

La siguiente lista detalla todas las partes de Spring Framework que son cubiertas a lo largo de la presente documentación:
- Inversión de Control (IoC)
- El framework Spring Web MVC
- Acceso a Datos mediante JPA
- Integración mediante tests

## Instalación
[Tabla de contenidos](#tabla-de-contenidos)

Recursos:
- https://vpsie.com/knowledge-base/how-to-install-spring-tool-suitests-4-in-ubuntu/
- https://zaaiiks.wordpress.com/2019/06/10/instalar-spring-tool-suite-en-ubuntu/
- https://www.youtube.com/watch?v=9XoaU5IMkRY
- https://www.youtube.com/watch?v=wT-hIeYyxBg
- SpringBoot CRUD +en MySQL
  - https://www.youtube.com/watch?v=M7lhQMzzHWU
    - Min14
  

- Adicionales:
  - https://www.youtube.com/watch?v=EsEWOQ-ms98
  - https://escuela.it/cursos/curso-spring-boot

- Instalar JDK 
- Instalar Spring Tools 4 for Eclipse
  - https://spring.io/tools
  - Realizamos la descarga y descomprimimos
```console
cd ~/Descargas
wget https://cdn.spring.io/spring-tools/release/STS4/4.22.0.RELEASE/dist/e4.31/spring-tool-suite-4-4.22.0.RELEASE-e4.31.0-linux.gtk.x86_64.tar.gz
mkdir sts
mv spring-tool-suite-4-4.22.0.RELEASE-e4.31.0-linux.gtk.x86_64.tar.gz sts
cd sts
tar -xvf spring-tool-suite-4-4.22.0.RELEASE-e4.31.0-linux.gtk.x86_64.tar.gz
sudo mv sts-4.22.0.RELEASE /usr/share/sts
cd /usr/share/sts
ls # Listamos varios archivos para el Acceso directo

# Ejecutamos una primera vez para comprobar...
./SpringToolSuite4
```

- Procedemos a crear el acceso directo:
```console
# Ahora creamos el acceso directo para Elementary
cd /usr/share/applications
sudo nano sts.desktop
```

- El contenido de sts.dekstop será:
  - En /usr/share/applications/sts.desktop:
```console
[Desktop Entry]
Version=1.0
Type=Application
Name=STS
GenericName=STS
Comment=STS
Exec=/usr/share/sts/SpringToolSuite4
TryExec=/usr/share/sts/SpringToolSuite4
Icon=/usr/share/sts/icon.xpm
Terminal=false

# Es posible que haya que actualizar la BBDD de enlaces:
# update-desktop-database /usr/share/applications
# CTRL + O, para guardar; CTRL + X para salir
```
- La primera vez que iniciemos preguntará por el Workspance. Poner este:
  - $HOME/Documents/workspace-sts
- Para ponerlo en español hacemos lo siguiente:
  - 1. Para ponerlo en español: Help > Install new software
  - 2. En Name ponemos Babel y en Location: https://download.eclipse.org/technology/babel/update-site/latest/
  - 3. Tras unos segundos (¡tarda un poquito!), le damos a Babel Language Packs in Spanish, marcando la casilla y pulsamos [Next]
  - 4. De nuevo tras varios segundos, le damos a [next], aceptamos la licencia y [Finish]. Cuando termine la instalación (miramos la esquina inferior derecha), reiniciamos Eclipse.
  > ATENCIÓN: Hay paquetes que debemos seleccionar que NO están firmados. No pasa nada, está todo controlado

<div style="page-break-after: always;"></div>

## Hola Mundo
[Tabla de contenidos](#tabla-de-contenidos)

- Recursos: 
  - https://dev.to/reytech-lesson/spring-boot-hello-world-example-by-using-sts-4nn

1. Archivo > Nuevo > Spring Startet Project
2. Dejamos las opciones por defecto. Nombre: HolaMundo. Ponemos en Type: Maven
3. Sprin Boot Version: 3.2.3: 
  - Elegir Developer Tools > Sprint Boot DevTools. Marcarlo.
  - Elegir Template Engines > Thymeleaf.  Marcarlo.
  - Elegir Web > Spring Web. Marcarlo. Y [Siguiente]
4. Pulsamos [Finalizar]. Esperamos un ratito...
5. Archivos para repasar:
  - /src/main/java > HolaMundoApplication.java
  - /src/test/java > HolaMundoApplicationTest.java
  - /pom.xml -> Ver sección dependencies

6. Ahora nos creamos el controlador:
  - Botón derecho en src/main/java > Nuevo > Paquete
    - Nombre: com.soltel.holamundo.controller > finalizar
  - Botón derecho en src/main/java/com.soltel.hola.controller
    - Nuevo > Clase. Nombre: HolaController
7. Escribimos lo siguiente en el controlador HolaController.java:
  - En HolaMundo/src/main/java/com.soltel.holamundo/HolaMundoApplication.java    
```java
package com.soltel.holamundo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Escribimos el @seguido del resto de la anotación e importamos:
@RestController
@SpringBootApplication
public class HolaMundoApplication {

	@RequestMapping(value="/")
	public String index() {
		return "<h1>Hola Mundo</h1>";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HolaMundoApplication.class, args);
	}

}
```
8. Botón derecho sobre HolaMundo (en el explorador de Paquetes).
  - Ejecutar como > Spring boot App
  - Probamos en el navegador: http://localhost:8080/





## CRUD MySQL
[Tabla de contenidos](#tabla-de-contenidos)

- Recursos:
  - https://spring.io/guides/gs/accessing-data-mysql/
  - https://www.adictosaltrabajo.com/2019/12/26/hibernate-uso-de-generationtype-y-otras-anotaciones/

Vamos a ver como crear un proyecto de una forma alternativa:
  - Usando start.spring
  - Usando IntelliJ Idea Community

### Estructura del Proyecto
[Tabla de contenidos](#tabla-de-contenidos)

1. Nos vamos a https://start.spring.io/
2. Configuramos el proyecto: 
  - Tipo: Maven. Language: Java. Versión: 3.2.1
  - Group: com.soltel
  - Artifact: CrudMySQL. Descripción: CrudMySQL
  - Dependencies: [Add]. Metemos: Spring Web, MySQL Driver, JPA, 
3. Le damos a [Generate] y vemos el ZIP.
4. Descomprimimos el ZIP en el workspace y abrimos el proyecto en IntelliJ Idea (o bien si queremos en Visual Studio con la extensión Spring Boot Extension Pack o el STS)
5. Configuramos la aplicación:
  - En /src/main/resources/application.properties
```properties
server.port=8100
spring.datasource.url="jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true"
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=none
```
6. Nos creamos las siguientes carpetas:
  - En /src/main/java/com.soltel.CrudMySQL
  - Botón derecho > New > Package 
    - controllers -> Controladores
    - models -> modelos (para BBDD)
    - repositories -> repositorios (para BBDD)
    - services -> servicios

7. Nos creamos los siguientes archivos de Java:
  - En /src/main/java/com.soltel.CrudMySQL
    - En controllers -> UserController (New > Java Class > Class)
    - En models -> UserModel (New > Java Class > Class)
    - En repositories -> IUserRepository (New > Java Class > Interface)
    - En services -> UserService (New > Java Class > Class)

<div style="page-break-after: always;"></div>

### Consulta Genérica
[Tabla de contenidos](#tabla-de-contenidos)

De forma resumida, tenemos que hacer 4 passos:
1. Definir el Modelo (UserModel)
2. Desarrollar la Interfaz repositorio (que hereda de JPA)
3. Usar la interfaz en el Servicio
4. Implementar el controlador

Vamos a usar anotaciones, comenzando por @
Importante fijarse bien en las importaciones.
Además, meteremos Getter y Setter usando IntelliJ

1. Modificamos el archivo UserModel
  - En /src/main/java/com.soltel.CrudMySQL/models/UserModel
  > NOTA: NO hace falta poner los import. Al colocar las anotaciones, nos aparecerá. Hay que fijarse en importar **LOS CORRECTOS** 
```java
package com.soltel.CrudMySQL.models;
import jakarta.persistence.*;

@Entity
@Table(name="user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private integer id;

    // ATENCIÓN: Una cosa es el nombre de la variable en Java
    // y otra el nombre del campo en la BBDD: first_name
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column
    private String email;

    // Definimos Getter y setter
    // Botón derecho Generate > Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

2. Ahora nos vamos al repositorio donde unicamente heredamos de JPA
- En /src/main/java/com.soltel.CrudMySQL/repositories/IUserRepository:
```java
package com.soltel.CrudMySQL.repositories;

import com.soltel.CrudMySQL.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// Clase para hacer consultas a la BBDD

// Heredamos de nuestro Modelo y del genérico Long
@Repository
public interface IUserRepository  extends JpaRepository<UserModel, Long> {
}
```

3. Desarrollamos el servicio:
- En /src/main/java/com.soltel.CrudMySQL/services/UserService
```java
package com.soltel.CrudMySQL.services;

import com.soltel.CrudMySQL.models.UserModel;
import com.soltel.CrudMySQL.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    // Inyección de dependencias
    @Autowired
    IUserRepository userRepository;

    // Dentro del userRepository (el nuestro) heredamos de JPA
    // Entre los métodos de JPA está findAll() (SELECT * FROM ..)
    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }
}
```



Ahora toca el controlador:
- En /src/main/java/com.soltel.CrudMySQL/controllers/UserController
```java
package com.soltel.CrudMySQL.controllers;

import com.soltel.CrudMySQL.models.UserModel;
import com.soltel.CrudMySQL.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/user")        // localhost/user
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }
}
```

<div style="page-break-after: always;"></div>

### Crear BBDD y Probar
[Tabla de contenidos](#tabla-de-contenidos)

En este primer ejemplo, vamos a empezar por visualizar todos los datos de una BBDD que crearemos a mano. Luego añadiremos la forma de crear la bbdd mediante un endpoint.

1. Creamos la BBDD user con la tabla user:
```console
mysql -u root -p
```

```sql
CREATE DATABASE user;
USE user;
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100)
);
INSERT INTO user (first_name, last_name, email) 
VALUES 
('Nombre1', 'Apellido1', 'correo1'),
('Nombre2', 'Apellido2', 'correo2');
```

2. Instalamos postman
- Nos vamos a https://dl.pstmn.io/download/latest/linux64
  - Se bajar el archivo: postman-linux-x64.tar.gz
```console
cd ~/Descargas
tar -xvf postman-linux-x64.tar.gz
sudo mv Postman /usr/share/postman
cd /usr/share/postman
# Ejecutamos una primera vez para comprobar...
./Postman
```

- Procedemos a crear el acceso directo:
```console
# Ahora creamos el acceso directo para Elementary
cd /usr/share/applications
sudo nano postman.desktop
```

- El contenido de postman.desktop será:
  - En /usr/share/applications/postman.desktop:
```console
[Desktop Entry]
Version=1.0
Type=Application
Name=Postman
GenericName=Postman
Comment=Postman
Exec=/usr/share/postman/Postman
TryExec=/usr/share/postman/Postman
Icon=/usr/share/postman/app/icons/icon_128x128.png
Terminal=false

# Es posible que haya que actualizar la BBDD de enlaces:
# sudo update-desktop-database /usr/share/applications
# CTRL + O, para guardar; CTRL + X para salir
``` 
- Aprovechamos e iniciamos Postman

3. Iniciamos la aplicación en IntelliJ Idea
  - Abrimos el archivo CrudMySqlApplication.java
    - En /src/main/java/com.soltel.CrudMySQL/CrudMySqlApplication.java
    - Botón derecho > Run
6. Nos vamos al Postman 
  - En la URL dejamos puesto GET y la dirección: 
    - http://localhost:8000/user
    - Pulsamos [Send] y nos aparecen nuestros datos.


### Operaciones CRUD
[Tabla de contenidos](#tabla-de-contenidos)

Tras comprobar que tanto la conexión, como el mapeo y el SELECT * FROM user son correctos, toda hacer el resto del crud.
Lo primer es BORRAR la BBDD de user y volverla a crear. Vamos a comprobar como springBoot crea por nosotros la tabla con los campos:
```mysql
DROP DATABASE user;
CREATE DATABASE user;
``` 

1. El orden siempre será el mismo: Primero el servicio, luego el controlador.
2. Iré enumando cada uno de los elementos entre comentarios y corchetes, por ejemplo [1]
3. Los archivos a tocar serán por este orden:
  - En /src/main/java/com.soltel.CrudMySQL/services/UserService
```java
@Service
public class UserService {

   // ...
    // Seguimos con el resto del CRUD

    // [1a] CREATE (guardar)
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    // [2a] READ (Consultar)
    // Optional: Puede devolver algo o NULL
    public Optional<UserModel> getById(Integer id) {
        return userRepository.findById(id);
    }

    // [3a] UPDATE (Actualizar)
    // OJO! Es un PUT
    public UserModel  updateById(UserModel request, Integer id){
        UserModel user = userRepository.findById(id).get();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        userRepository.save(user); // OJO!, fundamental!
        return user;
    }

    // [4a] DELETE (Borrar)
    public Boolean deleteUser (Integer id) {
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
```  

  - En /src/main/java/com.soltel.CrudMySQL/controllers/UserController
 ```java
@RestController
@RequestMapping("/user")        // localhost/user
public class UserController {

    //...

    // RequestBody -> Usamos el Body del Postman
    // [1b] CREATE (guardar)
    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    // [2b] READ (Consultar)
    // SELECT * FROM user WHERE id = {id}
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable Integer id){
        return this.userService.getById(id);
    }

    // [3b] UPDATE (Actualizar)
    // UPDATE user WHERE id = {id} SET...
    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel user, @PathVariable Integer id){
        return this.userService.updateById(user,id);
    }

    // [4b] DELETE (Borrar)
    // DELETE FROM user WHERE id = {id}
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.userService.deleteUser(id);
        if(ok){
            return "User con id " + id + " Borrado!";
        } else {
            return "Error, no hay User con " + id;
        }
    }
}
```   

4. Y ahora probamos toda la funcionalidad con PostMan:
- En Postman en la URL -> http://localhost:8000/user:
  - Hacemos un POST, pulsando en Body y seleccionando el tipo JSON:
```json
{
    "firstName": "Iván",
    "lastName": "Rodríguez",
    "email": "ivan.rodriguez@soltel.es"
}
```   

- En Postman en la URL -> http://localhost:8000/user:
  - Hacemos un GET y le damos a [Send]:
```json
{
    "firstName": "Iván",
    "lastName": "Rodríguez",
    "email": "ivan.rodriguez@soltel.es"
}
``` 

- En Postman en la URL -> http://localhost:8000/user/1:
  - Hacemos un GET y le damos a [Send]:
```json
{
    "id": 1,
    "firstName": "Iván",
    "lastName": "Rodríguez",
    "email": "ivan.rodriguez@soltel.es"
}
``` 

- En Postman en la URL -> http://localhost:8000/user/1:
  - Hacemos un PUT (para Update) y le damos a [Send]:
```json
{
    "firstName": "Iván Alfonso",
    "lastName": "Rodríguez",
    "email": "ivan.rodriguez@soltelsevilla.onmicrosoft.com"
}
``` 

- En Postman en la URL -> http://localhost:8000/user/1:
  - Hacemos un DEELTE (para Borrar) y le damos a [Send]:
```json
{
    "firstName": "Iván Alfonso",
    "lastName": "Rodríguez",
    "email": "ivan.rodriguez@soltelsevilla.onmicrosoft.com"
}
``` 

<div style="page-break-after: always;"></div>


### Subapartado 2.1
[Tabla de contenidos](#tabla-de-contenidos)

## Capitulo 3 - Proyecto Completo
[Tabla de contenidos](#tabla-de-contenidos)

- Vamos a ver ahora un ejemplo mas complejo. Desde este punto vamos a realizar lo siguiente:

- 1. Un CRUD completo sobre dos tablas (en este ejemplo, Clientes -> Reservas)
  - Al menos tendremos un campo de cada uno de los siguientes tipos:
    - Entero -> INTEGER
    - String -> VARCHAR
    - Decimal -> DECIMAL
    - Booleano -> TINYINT (BOOLEAN)
    - Fecha -> DATE
    - Ruta -> VARCHAR
- 2. Crear documentación de endpoints con Swagger
- 3. Crear formularios para gestionar el CRUD, incluyendo combos de filtrados y carga de archivos en PDF.
- 4. Crear formularios para gestionar consultas.
- 5. Definir un login de acceso a la aplicación
- 6. Definir un index con los enlaces correspondientes
- 7. Crear la capa de la vista en Angular. Incluir Popup
- 8. Incluir Spinner en la carga de datos

<div style="page-break-after: always;"></div>

### Creación del Proyecto
[Tabla de contenidos](#tabla-de-contenidos)

> **IMPORTANTE** Por comodidad, usaremos los IDEs Visual Studio Code (con la extensión Spring Boot Extension Pack) para codificar y STS (para ejecutar el proyecto y añadir los setter y getter)

- En este punto vamos a crear el proyecto usando el Inicializador de Spring Boot y además, creamos la Base de datos asociada. Todo sobre Islantilla...
Tablas: clientes y reservas
1. Nos vamos a https://start.spring.io/
  - Tipo: Maven (**IMPORTANTE**). Lenguaje: Java
  - Seleccionamos versión 3.2.3 (OJO, estable)
  - Package: Jar. Versión Java: 17
  - Dependencies: Spring Web, JPA y MySQL Driver.
2. Creamos la Base de datos (podemos usar MySQL WorkBench). El nombre será islantilla_spring. El SQL creado lo guardamos como islantilla.sql en el directorio de estáticos del proyecto.
**IMPORTANTE**: Evidentemente, tenemos que cargar la BBDD por el cliente MySQL.
  - En workspace-sts/islantilla/src/main/resources/static
```sql
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

-- [#] Cambio 20240318
-- Agregados los campos ruta_pdf y opciones JSON
CREATE TABLE reservas
(
	hab TINYINT NOT NULL,
    entrada DATE NOT NULL,
    nif VARCHAR(50) NOT NULL,
    precio DECIMAL (5,2) NOT NULL,
    ruta_pdf VARCHAR(255),
    opciones VARCHAR(255),
    PRIMARY KEY pk_reservas (hab, entrada),
    FOREIGN KEY fk_reservas (nif) REFERENCES clientes (nif)
);

-- Vamos a introducir datos
INSERT INTO clientes
VALUES ("12345678M", "Iván Rodríguez", 47, 0);

-- [#] Cambio 20240318
-- Agregadas las opciones adicionales ruta_pdf y opciones en el INSERT
INSERT INTO reservas 
VALUES (120, "2024-03-28", "12345678M", 75.50, 'reserva_20240318_001.pdf', 'spa,masajes'),
(118, "2024-03-23", "12345678M", 110.65, 'reserva_20240318_002.pdf', 'spa, masajes, balinesa');

SELECT * FROM clientes;
SELECT * FROM reservas;

```

3. Definimos las propiedades de conexión con la BBDD:
- En workspace-sts/islantilla/src/main/resources/application.properties
```properties
spring.application.name=islantilla
server.port=8100
# [#] Cambio 20240318
# Modificado el TimeZone de UTC a Europe/Madrid
spring.datasource.url=jdbc:mysql://localhost:3306/islantilla_spring?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Madrid
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=none

# [#] Cambio 20240318
# OJO! El driver para MySQL se ha modificado
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

4. Ahora creamos un endpoint para comprobar que todo está correcto:
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/IslantillaApplication.java
```java
package com.soltel.islantilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
public class IslantillaApplication {

	@RequestMapping(value = "/")
    public String index() {
        return "<h1>Bienvenidos a Islantilla!</h1>";
    }
	
	@RequestMapping(value = "/menu")
    public String menu() {
        return "<h1>Menu Principal</h1>";
    }
	
	@RequestMapping(value = "/fin")
    public String fin() {
        return "<h1>Fin Aplicación</h1>";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(IslantillaApplication.class, args);
	}

}
```

5. Probamos con STS: Botón derecho sobre el proyecto (islantilla) > Ejecutar como > Spring Boot App. 
6. En el navegador probar en: http://localhost:8100/

### Definición de modelos
[Tabla de contenidos](#tabla-de-contenidos)

- Vamos a tener tantos modelos como tablas: ClientesModel.java y ReservasModel.java
- Seguiremos las convenciones para determinados métodos.
- Como en la tabla Reservas tenemos una clave compuesta (hab -> habitaciones, y entrada -> fecha entrada reserva), debemos crearnos una clase auxiliar con la clave principal, que se llamará ReservasId.java.

**IMPORTANTE** En el modelo de clientes agregaremos el campo relacionado en paso posterior, tras crear ReservasModel:

1. Nos creamos el paquete (botón derecho > Crear paquete o carpeta) models en la carpeta de islantilla:
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla

2. Dentro creamos un archivo java: ClientesModel.java
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/models/ClientesModel.java
```java
package com.soltel.islantilla.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;


/**
 * IMPORTANTE: Para las entidades el orden es:
 * 1) ClientesModel (la tabla principal)
 * 2) ReservasId (por la clave compuesta)
 * 3) ReservasModel (la tabla secundaria)
 */
@Entity
@Table(name = "clientes")
public class ClientesModel {

    // Atributos (campos BBDD)
    @Id
    private String nif;

    @Column (name = "nombre")
    private String nombre;

    @Column
    private int edad;

    // OJO, se guarda en la BBDD como 1 o 0 (tinyint)
    @Column
    private int sexo;

    // El OneToMany lo dejamos para despues...
    /*
    @OneToMany (mappedBy = "cliente")
	private Set<ReservasModel> reservas;
    */

    // Setter y Getter
    
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	// Constructores
	public ClientesModel() {}
	
	public ClientesModel(String nif, String nombre, int edad, int sexo) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}
    
}

```

2. Ahora creamos el Modelo para la clave compuesta de Reservas:
**IMPORTANTE** Para crear el constructor, los setter y getter así como el hashCode y el equals se recomienda encarecidamente usar las opciones que da STS (Botón derecho > Codigo Fuente > Generar...)
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/models/ReservasId.java
```java
package com.soltel.islantilla.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ReservasId implements Serializable{
    private int hab;
    private LocalDate entrada;
    
    // Constructores
    public ReservasId() {}
    
	public ReservasId(int hab, LocalDate entrada) {
		super();
		this.hab = hab;
		this.entrada = entrada;
	}

	// Setter y Getter
	public int getHab() {
		return hab;
	}

	public void setHab(int hab) {
		this.hab = hab;
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(entrada, hab);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservasId other = (ReservasId) obj;
		return Objects.equals(entrada, other.entrada) && hab == other.hab;
	}
}
```

3. Y ahora creamos el modelo para reservas:
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/models/ReservasModel.java
```java
package com.soltel.islantilla.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.time.LocalDate;

// Tenemos que definir cual será la clave principal en otra clase
// OJO! Solo para claves compuestas
@Entity
@Table(name = "reservas")
@IdClass(ReservasId.class)
public class ReservasModel {

    @Id
    private int hab;

    @Id
    private LocalDate entrada;

    @ManyToOne
    @JoinColumn(name = "nif", nullable = false)
    private ClientesModel cliente;

    @Column
    private float precio;

	// [#] Cambio 20240318
	@Column(name = "ruta_pdf")
	private String rutaPdf;

	// [#] Cambio 20240318
	@Column (name = "opciones")
	private String opciones;

    // Constructores
    public ReservasModel() {	}
    
	// [#] Cambio 20240318
	public ReservasModel(int hab, LocalDate entrada, ClientesModel cliente, float precio,
	String rutaPdf, String opciones) {
		super();
		this.hab = hab;
		this.entrada = entrada;
		this.cliente = cliente;
		this.precio = precio;
		this.rutaPdf = rutaPdf;
		this.opciones = opciones;
	}
	
	// Setter y Getter
	public int getHab() {
		return hab;
	}

	public void setHab(int hab) {
		this.hab = hab;
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ClientesModel getCliente() {
		return cliente;
	}

	public void setCliente(ClientesModel cliente) {
		this.cliente = cliente;
	}

	// Nuevos Setter y Getter
	// [#] Cambio 20240318
	public String getRutaPdf() {
		return rutaPdf;
	}

	public void setRutaPdf(String rutaPdf) {
		this.rutaPdf = rutaPdf;
	}

	public String getOpciones() {
		return opciones;
	}

	public void setOpciones(String opciones) {
		this.opciones = opciones;
	}
}
```

4. Y ahora agregamos el ManyToOne en ClientesModel
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/models/ClientesModel.java
```java
// ...
  // OJO, se guarda en la BBDD como 1 o 0 (tinyint)
    @Column
    private int sexo;

    // Hay que poner en la relación de tablas, OneToMay en el 1 y ManyToOne en el muchos
    // Aquí ponemos el OneToMany. El mapeo hay que ponerle el nombre de la entidad en singular
	// mappedBy = "cliente" debe coincidir con el nombre del campo en la tabla Reservas
    @OneToMany (mappedBy = "cliente")
	private Set<ReservasModel> reservas;
    
    // Setter y Getter
    
	public String getNif() {
		return nif;
	}
// ...
```


### Gestión de Clientes
[Tabla de contenidos](#tabla-de-contenidos)

El proceso para gestionar el CRUD de una tabla (Create (INSERT), Read (SELECT), Update y Delete) en Spring comprende 4 pasos:
1. Crear el modelo (visto en el apartado anterior)
2. Crear el repositorio donde nos crearemos nuestras consultas personalizadas. Por ahora tan solo lo definimos:
  - Creamos el paquete repositories en workspace-sts/islantilla/src/main/java/com/soltel/islantilla/
  - Ponemos lo siguiente en workspace-sts/islantilla/src/main/java/com/soltel/islantilla/repositories/IClientesRepository.java
> NOTA: Por convención los nombres de las clases para repositorios será I (de interfaz) + Tabla + Repository. OJO! Hay que crear un interfaz que hereda de JPA
```java
package com.soltel.islantilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.soltel.islantilla.models.ClientesModel;

// Se hereda de JpaRepository y se especifica <Modelo, TipoPK)
@Repository
public interface IClientesRepository extends JpaRepository<ClientesModel, String> {

}
```
3. Ahora definimos el servicio, que tendrá. de forma centralizada, los métodos a emplear para el CRUD.
  - Nos creamos un paquete services en workspace-sts/islantilla/src/main/java/com/soltel/islantilla/
  - En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/services/ClientesService.java
```java
package com.soltel.islantilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soltel.islantilla.models.ClientesModel;
import com.soltel.islantilla.repositories.IClientesRepository;

@Service
public class ClientesService {
    private final IClientesRepository clientesRepository;

    // Constructor para cargar el repositorio que yo he hecho
    // Inyecto la dependencia
    @Autowired
    public ClientesService(IClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    // Creo mis propios métodos para hacer consultas
    // findAll -> SELECT * FROM Clientes
    // OJO! Este nombre es por convención: findAllClientes
    public List<ClientesModel> findAllClientes() {
        return clientesRepository.findAll();
    }

    // findBy(nif) -> SELECT * FROM Clientes WHERE nif = ?
    // Por convención: findByClientesByNif
    public Optional<ClientesModel> findByClientesByNif(String nif) {
        return clientesRepository.findById(nif);
    }

    // COMO ES VIERNES os voy a pasar los métodos para hacer el CRUD
    // insert, update, delete
    public ClientesModel saveCliente (ClientesModel cliente) {
        return clientesRepository.save(cliente);
    }

    public ClientesModel updateCliente (ClientesModel cliente) {
        return clientesRepository.save(cliente);
    }

    public void deleteCliente (String nif) {
        clientesRepository.deleteById(nif);
    }
}
```

4. En la última capa, en el controlador,definimos los endpoints que vamos a emplear, usando los métodos del servicio.
  - Nos creamos un paquete controllers en workspace-sts/islantilla/src/main/java/com/soltel/islantilla/
  - En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/controllers/ClientesController.java
```java
package com.soltel.islantilla.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soltel.islantilla.models.ClientesModel;
import com.soltel.islantilla.services.ClientesService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    // Atributo principal
    private final ClientesService clientesService;

    // Constructor
    public ClientesController (ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    // Método de consulta general
    // endpoint de ejemplo: http://localhost:8100/clientes/consultar
    @GetMapping("/consultar")
    public ResponseEntity<List<ClientesModel>> getAllClientes(){
        return ResponseEntity.ok(clientesService.findAllClientes());
    }

    // Método de consulta por campo
    // endpoint de ejemplo: http://localhost:8100/clientes/consultar/23456789g
    @GetMapping("/consultar/{nif}")
    public ResponseEntity<?> getClienteByNif(@PathVariable String nif) {
      // Convierto el nif en mayúsculas
      nif = nif.toUpperCase();
    	Optional<ClientesModel> cliente = clientesService.findByClientesByNif(nif);
        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    // endpoint de ejemplo: http://localhost:8100/clientes/insertar/12345667M/Iván/47/0
    @PostMapping("/insertar{nif}/{nombre}/{edad}/{sexo}")
    public ResponseEntity<ClientesModel> createCliente (@PathVariable String nif, 
        @PathVariable String nombre, @PathVariable int edad, @PathVariable int sexo) {
            ClientesModel nuevoCliente  = new ClientesModel(nif, nombre, edad, sexo);
            ClientesModel guardaCliente = clientesService.saveCliente(nuevoCliente);
            return ResponseEntity.ok(guardaCliente);
        }

    // Método para actualizar
    // endpoint de ejemplo:  
    // [PUT] http://localhost:8100/clientes/actualizar/23456789G/Perico/38/0
    @PutMapping("/actualizar/{nif}/{nombre}/{edad}/{sexo}")
    public ResponseEntity<?> updateCliente(@PathVariable String nif, 
                @PathVariable String nombre, @PathVariable int edad, @PathVariable int sexo) {
        Optional<ClientesModel> cliente = clientesService.findByClientesByNif(nif);
        if(cliente.isPresent()) {
            ClientesModel clienteActualizado = cliente.get();
            clienteActualizado.setNombre(nombre);
            clienteActualizado.setEdad(edad);
            clienteActualizado.setSexo(sexo);
            ClientesModel guardaCliente = clientesService.updateCliente(clienteActualizado);
            return ResponseEntity.ok(guardaCliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }
    
    
    // Método para actualizar por nombre
    // endpoint de ejemplo:  
    // [PUT] http://localhost:8100/clientes/actualizar/23456789G/Federico/
    @PutMapping("/actualizar/{nif}/{nombre}/")
    public ResponseEntity<?> updateNombreCliente(@PathVariable String nif, 
                @PathVariable String nombre) {
        Optional<ClientesModel> cliente = clientesService.findByClientesByNif(nif);
        if(cliente.isPresent()) {
            ClientesModel clienteActualizado = cliente.get();
            clienteActualizado.setNombre(nombre);
            ClientesModel guardaCliente = clientesService.updateCliente(clienteActualizado);
            return ResponseEntity.ok(guardaCliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    // Método para eliminar un cliente
    // endpoint de ejemplo: http://localhost:8100/clientes/eliminar/12345678M
    @DeleteMapping("/eliminar/{nif}")
    public ResponseEntity<String> deleteCliente(@PathVariable String nif) {
        clientesService.deleteCliente(nif);
        return ResponseEntity.ok("Cliente eliminado con éxito");
    }
}
```

5. Y empezamos a probar con Postman:
  - [GET] http://localhost:8100/clientes/consultar
  - [POST] http://localhost:8100/clientes/insertar/23456789G/Sara/40/1
  - [GET] http://localhost:8100/clientes/consultar
  - [PUT] http://localhost:8100/clientes/actualizar/23456789G/Alfonso/41/0
  - [GET] http://localhost:8100/clientes/consultar
  - [DELETE] http://localhost:8100/clientes/eliminar/23456789G

### Gestión de Reservas
[Tabla de contenidos](#tabla-de-contenidos)

> **ATENCIÓN** En application.properties definir bien el TimeZone a Timezone=Europe/Madrid. Quedará el application.properties:
```properties
spring.application.name=islantilla
server.port=8100
# [#] Cambio 20240318
# Modificado el TimeZone de UTC a Europe/Madrid
spring.datasource.url=jdbc:mysql://localhost:3306/islantilla_spring?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Madrid
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=none

# [#] Cambio 20240318
# OJO! El driver para MySQL se ha modificado
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

1. Definimos el repositorio (IReservasRepository):
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/repositories
```java
package com.soltel.islantilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soltel.islantilla.models.ReservasId;
import com.soltel.islantilla.models.ReservasModel;

// Se hereda de JpaRepository y dentro de <> se pone <Modelo, Clase IDModelo>
@Repository
public interface IReservasRepository extends JpaRepository <ReservasModel, ReservasId>{

}

```
2. Ahora creamos el servicio (ReservasService.java)
> NOTA: La forma mas sencilla para trabajar con arrays en la BBDD es definirlo como hemos hecho con un String y pasarlo por comas en el endpoint
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/services/ReservasService.java
```java
package com.soltel.islantilla.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soltel.islantilla.models.ReservasId;
import com.soltel.islantilla.models.ReservasModel;
import com.soltel.islantilla.repositories.IReservasRepository;

@Service
public class ReservasService {
    private final IReservasRepository reservasRepository; 

    @Autowired
    public ReservasService(IReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }

    // Métodos de consulta
    public List<ReservasModel> findAllReservas() {
        return reservasRepository.findAll();
    }

    // OJO, el findById, aquí es diferente. Hay que meter el objeto ReservasId
    public Optional<ReservasModel> findReservaById (int hab, LocalDate entrada) {
        ReservasId id = new ReservasId(hab, entrada);
        return reservasRepository.findById(id);
    }

    // Métodos de accion: INSERT, UPDATE y DELETE
    // Este sirve tanto para INSERT como UPDATE
    public ReservasModel saveReserva (ReservasModel reserva) {
        return reservasRepository.save(reserva);
    }

    public void deleteReserva (int hab, LocalDate entrada) {
        ReservasId id = new ReservasId(hab, entrada);
        reservasRepository.deleteById(id);
    }
}

```

3. Crear el controlador (ReservasController.java)
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/controller
```java
package com.soltel.islantilla.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.soltel.islantilla.models.ClientesModel;
import com.soltel.islantilla.models.ReservasModel;
import com.soltel.islantilla.services.ClientesService;
import com.soltel.islantilla.services.ReservasService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

    // Como atributos, introduzco los servicios de ambas tablas
    private final ClientesService clientesService;
    private final ReservasService reservasService;

    // Inyecto en la clase ambos servicios en el constructor
    @Autowired
    public ReservasController (ClientesService clientesService,
    ReservasService reservasService) {
        this.clientesService = clientesService;
        this.reservasService = reservasService;
    }

    // Método para consultar
    // Equivale SELECT * FROM reservas
    // Endpoint de ejemplo: [GET] http://localhost:8100/reservas/consultar
    @GetMapping("/consultar")
    public ResponseEntity<List<ReservasModel>> getAllReservas() {
        return ResponseEntity.ok(reservasService.findAllReservas());
    }
    
    // Método para consultar por clave principal (hab, entrada)
    // Endpoint de ejemplo: [GET] http://localhost:8100/reservas/consultar/118/2024-03-23
    // OJO, hay que convertir la fecha -> @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)) 
    @GetMapping("/consultar/{hab}/{entrada}")
    public ResponseEntity<?> getReservaById (@PathVariable int hab, 
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada) {
        Optional<ReservasModel> reserva = reservasService.findReservaById(hab, entrada);
        if(reserva.isPresent()) {
            return ResponseEntity.ok(reserva.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Reserva no encontrada!");
        }
    }
    
    // Método para insertar
    // Endpoint de ejemplo: [POST] 
    // http://localhost:8100/reservas/insertar/118/2024-04-06/12345678M/110.65/reserva_20240318_003.pdf/spa,masajes,balinesa
    @PostMapping("/insertar/{hab}/{entrada}/{nif}/{precio}/{rutaPdf}/{opciones}")
    public ResponseEntity<?> createReserva (@PathVariable int hab, @PathVariable LocalDate entrada,
        @PathVariable String nif, @PathVariable float precio, 
        @PathVariable String rutaPdf, @PathVariable String opciones) {
        
        // 1º Busco si la reserva YA existe
        Optional<ReservasModel> reserva = reservasService.findReservaById(hab, entrada);
        // 2º Tengo que buscar el cliente a partir del nif
        Optional<ClientesModel> clienteBuscado = clientesService.findByClientesByNif(nif);

        if(reserva.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reserva existente!");
        } else if(clienteBuscado.isPresent()){
            ReservasModel nuevaReserva = new ReservasModel();
            ClientesModel cliente = clienteBuscado.get();

            // Hago la asignación de todos los atributos (incluido el objeto Cliente)
            nuevaReserva.setHab(hab);
            nuevaReserva.setEntrada(entrada);
            nuevaReserva.setPrecio(precio);
            nuevaReserva.setCliente(cliente);
            nuevaReserva.setRutaPdf(rutaPdf);
            nuevaReserva.setOpciones(opciones);

            // Tengo que hacer la INSERCIÓN!!
            ReservasModel reservaGuardada = reservasService.saveReserva(nuevaReserva);
            return ResponseEntity.ok(reservaGuardada);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente no existe");
        } 
    }
    
    
    // Método para actualizar
    // NOTA: Ejecutar antes [POST] http://localhost:8100/clientes/insertar/23456789G/Sara/40/1
    // Endpoint de ejemplo: [PUT] 
    // http://localhost:8100/reservas/actualizar/118/2024-04-06/23456789G/90.55/reserva_20240319_001.pdf/spa,masajes,balinesa
    @PutMapping("/actualizar/{hab}/{entrada}/{nif}/{precio}/{rutaPdf}/{opciones}")
    public ResponseEntity<?> updateReserva (@PathVariable int hab, @PathVariable LocalDate entrada,
        @PathVariable String nif, @PathVariable float precio, 
        @PathVariable String rutaPdf, @PathVariable String opciones) {
        
        // 1º Busco si la reserva YA existe
        Optional<ReservasModel> reserva = reservasService.findReservaById(hab, entrada);
        // 2º Tengo que buscar el cliente a partir del nif
        Optional<ClientesModel> clienteBuscado = clientesService.findByClientesByNif(nif);

        if(!reserva.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reserva NO existe!");
        } else if(clienteBuscado.isPresent()){
            ReservasModel reservaActualizada = reserva.get();
            ClientesModel cliente = clienteBuscado.get();

            // Hago la asignación de todos los atributos (incluido el objeto Cliente)
            reservaActualizada.setPrecio(precio);
            reservaActualizada.setCliente(cliente);
            reservaActualizada.setRutaPdf(rutaPdf);
            reservaActualizada.setOpciones(opciones);

            // Tengo que hacer la INSERCIÓN!!
            ReservasModel reservaGuardada = reservasService.saveReserva(reservaActualizada);
            return ResponseEntity.ok(reservaGuardada);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente no existe");
        } 
    }
    
    // Método para borrar
    // Endpoint de ejemplo: [DELETE] http://localhost:8100/reservas/eliminar/120/2024-03-28
    @DeleteMapping("/eliminar/{hab}/{entrada}")
    public ResponseEntity<?> deleteReserva (@PathVariable int hab, @PathVariable LocalDate entrada) {

        // 1º Busco si la reserva YA existe
        Optional<ReservasModel> reserva = reservasService.findReservaById(hab, entrada);

        if(!reserva.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reserva NO existe!");
        } else {
            // Ejecuto el borrado si la reserva existe
            reservasService.deleteReserva(hab, entrada);
            return ResponseEntity.ok("Reserva eliminada!");
        } 
    }
}

```

5. Y empezamos a probar con Postman:
  - [GET] http://localhost:8100/reservas/consultar
  - [GET] http://localhost:8100/reservas/consultar/118/2024-03-23
  - [POST] http://localhost:8100/reservas/insertar/118/2024-04-06/12345678M/110.65/reserva_20240318_003.pdf/spa,masajes,balinesa
  - [GET] http://localhost:8100/reservas/consultar
  - [POST] http://localhost:8100/clientes/insertar/23456789G/Sara/40/1
  - [PUT] http://localhost:8100/reservas/actualizar/118/2024-04-06/23456789G/90.55/reserva_20240319_001.pdf/spa,masajes,balinesa
  - [GET] http://localhost:8100/reservas/consultar
  - [DELETE] http://localhost:8100/reservas/eliminar/120/2024-03-28

### Consultas Adicionales
[Tabla de contenidos](#tabla-de-contenidos)

Ahora vamos a crearnos una consulta personalizada, un JOIN que reuna varios campos de ambas tablas por este orden: nif, nombre, sexo (escribir en la salida, en el JSON, "mujer" para 1 y "hombre" para 0), hab, entrada, precio, ruta_pdf y opciones 

1. Para empezar nos vamos al paquete de modelos. Vamos a crearnos una clase que va a definir el objeto de respuesta (el JSON con los campos que queramos):
En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/models/JoinReservasClientes.java
```java
package com.soltel.islantilla.models;

import java.time.LocalDate;

public class JoinReservasClientes {
    // Atributos del modelo (salida JSON)
    private int hab;
    private LocalDate entrada;
    private String nif;
    private String nombre;
    private int edad;
    private float precio;
    private String rutaPdf;
    private String opciones;
    
    // Constructores
	public JoinReservasClientes() {
	}

	public JoinReservasClientes(int hab, LocalDate entrada, String nif, String nombre, int edad, float precio,
			String rutaPdf, String opciones) {
		this.hab = hab;
		this.entrada = entrada;
		this.nif = nif;
		this.nombre = nombre;
		this.edad = edad;
		this.precio = precio;
		this.rutaPdf = rutaPdf;
		this.opciones = opciones;
	}
    
    // Getters y setters
	//...
}
```

2. Luego definimos dos métodos en el repositorio de Reservas:
  - Un JOIN sin parámetros y otro con el parámetro hab
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/repositories/IReservasRepository.java
```java
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soltel.islantilla.models.JoinReservasClientes;
import com.soltel.islantilla.models.ReservasId;
import com.soltel.islantilla.models.ReservasModel;

// Se hereda de JpaRepository y dentro de <> se pone <Modelo, Clase IDModelo>
@Repository
public interface IReservasRepository extends JpaRepository <ReservasModel, ReservasId>{
	
    /*
     * Creamos una consulta personalizada (JOIN) en SQL seria asi:
     * SELECT r.hab, r.entrada, c.nif, c.nombre, c.edad, r.precio, r.ruta_pdf, r.opciones
     * FROM reservas r JOIN clientes c
     * WHERE r.nif = c.nif
     */

     /*
      * Vamos a usar una consulta JPQL (Java Persistence Query Language)
      * Alias para clientes -> c; Alias para Reservas -> r
      * Campos: hab, entrada, nif, nombre, edad, precio, rutaPdf, opciones
      * r.cliente es el atributo de ReservasModel de la unión entre tablas
      *
      * OJO: Hay que poner la ruta COMPLETA del modelo del JOIN:
      * com.soltel.islantilla.models.JoinReservasClientes
      */ 
	@Query( "SELECT new com.soltel.islantilla.models.JoinReservasClientes(" +
		     "r.hab, r.entrada, c.nif, c.nombre, c.edad, " +
             "r.precio, r.rutaPdf, r.opciones) " +              // Agregado espacio aquí después de )
		     "FROM ReservasModel r JOIN r.cliente c")
		 
		    List<JoinReservasClientes> verReservasClientes();

    @Query( "SELECT new com.soltel.islantilla.models.JoinReservasClientes(" +
    "r.hab, r.entrada, c.nif, c.nombre, c.edad, " +
    "r.precio, r.rutaPdf, r.opciones) " +              // Agregado espacio aquí después de )
    "FROM ReservasModel r JOIN r.cliente c " +
    " ")
        
           List<JoinReservasClientes> 
                verReservasClientes(@Param("hab") int hab);
}
```

3. Ahora el servicio:
En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/services/ReservasService.java
```java
    // Creo un nuevo método para el JOIN
    public List<JoinReservasClientes> dameReservasClientes() {
        return reservasRepository.verReservasClientes();
    }


    // Creo un nuevo método para el JOIN filtrado por habitación
    public List<JoinReservasClientes> dameReservasClientes(int hab) {
        return reservasRepository.verReservasClientes(hab);
    }
```

4. Y por último el controlador
En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/controllers/ReservasController.java
```java

    // Método para hacer un JOIN con ambas tablas
    // Endpoint de ejemplo: [GET] http://localhost:8100/reservas/consultar/join
    @GetMapping("/consultar/join")
    public ResponseEntity<List<JoinReservasClientes>> consultarReservasClientes() {
        List<JoinReservasClientes> listaReservas = reservasService.dameReservasClientes();
        return ResponseEntity.ok(listaReservas);
    }

    // Método para hacer un JOIN con ambas tablas filtrado por un parámetro
    // Endpoint de ejemplo: [GET] http://localhost:8100/reservas/consultar/join/118
    @GetMapping("/consultar/join/{hab}")
    public ResponseEntity<List<JoinReservasClientes>> consultarReservasClientes(@PathVariable int hab) {
        List<JoinReservasClientes> listaReservas = reservasService.dameReservasClientes(hab);
        return ResponseEntity.ok(listaReservas);
    }
    
```

5. Para probarlo, con Postman, hacemos lo siguiente:
- [GET] http://localhost:8100/reservas/consultar/join
- [GET] http://localhost:8100/reservas/consultar/join/118

## Capitulo 4 - Swagger
[Tabla de contenidos](#tabla-de-contenidos)

- Recursos:
  - https://swagger.io/
  - https://github.com/springfox/springfox
  - https://www.youtube.com/watch?v=0Y-V78_XcrY

Vamos a ver como documentar los endpoints del proyecto:
1. Agregar las dependencias de Swagger en el pom:
> Nota: si da algún error, reiniciar el proyecto...
- En workspace-sts/islantilla/pom-xml
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<!-- SpringDoc OpenAPI UI -->
		 <dependency>
      		<groupId>org.springdoc</groupId>
      		<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      		<version>2.4.0</version>
   		</dependency>

	</dependencies>
```

2. Al agregar la dependencia, debemos hacer una instalación limpia (lo recomendable)
  - Botón derecho en islantilla > Ejecutar como > Maven build
  - Poner en Goals: clean install -DskipTest

3. Actualizamos el proyecto:
  - Botón derecho en islantilla > Maven > Update project
  - Reiniciamos islantilla en el panel Boot Dashboard: islantilla > [Re] start
4. Probamos en el navegador:
  - http://localhost:8100/swagger-ui/index.html

Ahora vamos a configurar la aplicación:
1. Creamos un archivo de configuración de openAPI:

- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/config/SwaggerConfig.java
> IMPORTANTE: Vamos a usar Angular 17.3.1
```java
package com.soltel.islantilla.config;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI personalizarAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Endpoints Islantilla")
                .description("Documentación Endpoints Islantilla")
                .version("1.0")
                .contact(new Contact()
                    .name("Iván Rodríguez")
                    .url("http://www.soltel.es")
                    .email("ivan.rodriguez@soltel.es"))
                .license(new License()
                    .name("MIT")
                    .url("https://www.mit.edu"))
                .termsOfService("Swagger de Islantilla. Sin Garantia"))
            .components(new Components()
                    .addSecuritySchemes("basicAuth", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("basic")))
            .servers(Arrays.asList(new Server()
                .url("http://localhost:8100").
                description("Entorno de pruebas")));
    }
}
```

2. Para quitar endpoints añadimos la anotación @Hidden en los controladores.
```java

import io.swagger.v3.oas.annotations.Hidden;
//...
public class IslantillaApplication {

    @Hidden
	@RequestMapping(value = "/inicio")
    public String index() {
        return "<h1>Bienvenidos a Islantilla!</h1>";
    }
```

3. Y para hacer mas descriptivo el endpoint, usaremos @tag
```java
import io.swagger.v3.oas.annotations.tags.Tag;
//...

@RestController
@RequestMapping("/clientes")
@Tag(name = "Endpoints Clientes")
public class ClientesController {
```


## Capitulo 5 - Angular 
[Tabla de contenidos](#tabla-de-contenidos)

> IMPORTANTE: Vamos a usar Angular 17.3.1
```console
sudo npm uninstall -g @angular/cli
sudo npm install -g @angular/cli@latest
sudo npm cache verify
ng version
```

1. Instalamos una aplicación Angular y los componentes necesarios:
```console
cd ~/Documents/workspace-sts/islantilla_spring
ng new islantilla_angular_v17 --no-standalone   # Añadimos routing
cd islantilla_angular_v17
npm install bootstrap@5

# Si hace falta corregimos vulnerabilidades
#npm audit fix --force

ng generate component formularios_clientes
ng generate class models/clientes --type=model
ng generate service services/clientes

# Generamos una carpeta environments
ng generate environments
```

2. Ponemos en el angular.json del proyecto el nuevo estilo con boostrap:
- En islantilla_spring/islantilla_angular/angular.json
```json
      "tsConfig": "tsconfig.app.json",
      "assets": [
        "src/favicon.ico",
        "src/assets"
      ],
      "styles": [
        "node_modules/bootstrap/dist/css/bootstrap.min.css",
        "src/styles.css"
      ],
      "scripts": []
```


3. Definimos en environment la dirección de la API general:
```ts
// Spring Boot 3.2 + Angular v17: Paso 1 -> Entornos

export const environment = {
    apiURL : "http://localhost:8100"
};
```

4. Nos creamos el modelo:
- En islantilla_spring/islantilla_angular/src/app/models/clientes.models.ts
```ts
// Spring Boot 3.2 + Angular v17: Paso 1 -> Modelo (interfaz)
export interface Clientes {
    nif: string
    nombre: string
    edad: number
    sexo: number
}
```


4. En el servicio ponemos el endpoint:
- En islantilla_spring/islantilla_angular/src/app/services/clientes.service.ts
```ts
// Spring + Angular: Paso2 -> Servicio
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Clientes } from '../models/clientes.model';

@Injectable({
  providedIn: 'root'
})

export class ClientesService {
  // Todos tendrán el mismo inicio de endpoint
  private baseURL = 'http://localhost:8100/clientes';

  constructor(private http: HttpClient) { }

  // Método para agregar clientes
  addCliente(cliente: Clientes) {
    const url = `${this.baseURL}/insertar/${cliente.nif}/${cliente.nombre}/${cliente.edad}/${cliente.sexo}`;
    return this.http.post(url, {});
  }
}
```

5. Ahora definimos un formulario dentro del componente formulario_clientes
- En islantilla_spring/islantilla_angular/src/app/formularios-clientes/formularios-clientes.component.ts
> Nota: En angular17, el controlador app.module.ts no existe. Hay que meter el código asi:
```ts
// Spring + Angular: Paso3 -> Controlador componente
// ESTO PARA ANGULAR 17!!
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms'; // Aqui meto el FormsModule
import { ClientesService } from '../services/clientes.service';

@Component({
  selector: 'app-formularios-clientes',
  templateUrl: './formularios-clientes.component.html',
  styleUrls: ['./formularios-clientes.component.css'],
  imports: [FormsModule],  // Importar FormsModule aquí
  standalone: true        // Marcar el componente como standalone
})
```

```ts
// Spring + Angular: Paso3 -> Controlador componente
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ClientesService } from '../services/clientes.service';

@Component({
  selector: 'app-formularios-clientes',
  templateUrl: './formularios-clientes.component.html',
  styleUrls: ['./formularios-clientes.component.css']
})
export class FormulariosClientesComponent {
  constructor(private clientesService: ClientesService) {}

  // El método puede llamarse como queramos. Por convención on (evento)
  onAddCliente(form: NgForm) {
    if(form.invalid) {
      return;
    }
    this.clientesService.addCliente(form.value).subscribe();

    // Una vez enviado el formulario, lo presento de nuevo vacio
    form.resetForm();
  }
}
```

6. Agregamos el Módulo HTTPClientModule y el FormsModule en el módulo principal:
- En islantilla_spring/islantilla_angular/src/app/app.module.ts
```ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormulariosClientesComponent } from './formularios-clientes/formularios-clientes.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    FormulariosClientesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

7. Ahora montamos el formulario en la capa vista del componente:
- En islantilla_spring/islantilla_angular/src/app/formularios-clientes/formularios-clientes.component.html
```html
<form (ngSubmit)="onAddCliente(form)" #form="ngForm" class="container mt-4">
    <!-- Otros campos... -->
    <div class="mb-3">
        <label for="nif" class="form-label">NIF</label>
        <input type="text" class="form-control" id="nif" ngModel name="nif" required>
    </div>
    <div class="mb-3">
        <label for="nombre" class="form-label">Nombre</label>
        <input type="text" class="form-control" id="nombre" ngModel name="nombre" required>
    </div>
    <div class="mb-3">
        <label for="edad" class="form-label">Edad</label>
        <input type="number" class="form-control" id="edad" ngModel name="edad" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Sexo</label>
        <div class="form-check">
            <input type="radio" class="form-check-input" id="sexoMujer" name="sexo" value="1" ngModel required>
            <label class="form-check-label" for="sexoMujer">Mujer</label>
        </div>
        <div class="form-check">
            <input type="radio" class="form-check-input" id="sexoHombre" name="sexo" value="0" ngModel required>
            <label class="form-check-label" for="sexoHombre">Hombre</label>
        </div>
    </div>

    <!-- Botón de envío... -->
        <button type="submit" class="btn btn-primary">Crear Cliente</button>
</form>
```

8. Ya solo nos queda agregarlo a la vista de la aplicación angular:
- En islantilla_spring/islantilla_angular/src/app/app.component.html
```html
<!-- Toolbar -->
<div class="toolbar" role="banner">
  <!-- //... -->
  <span>¡Saludos desde Symfony 6 y Angular 16!</span>
    <!-- //... -->
</div>

<section class="w-50 p-3 m-5">
<app-formularios-clientes></app-formularios-clientes>
</section>
```

9. Antes de seguir, debemos configurar CORS para comunicar Angular con Spring Boot:
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/config/MiConfiguracionCors.java
```java
package com.soltel.islantilla.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MiConfiguracionCors implements WebMvcConfigurer {

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

```


10. Para visualizarlo, abrirmos el servidor:
```console
cd islantilla_spring/islantilla_angular
ng serve
# Y lo veremos en el navegador: http://localhost:4200
```

Ahora repetimos el proceso para Reservas, usando el endpoint createReservas:

1. Instalamos una aplicación Angular y los componentes necesarios:

```console
cd ~/Documents/workspace-sts/islantilla_spring
cd islantilla_angular
ng generate component formularios_reservas
ng generate class models/reservas --type=model
ng generate service services/reservas
```

2. Nos creamos el modelo:
- En islantilla_spring/islantilla_angular/src/app/models/reservas.models.ts
```ts
export class Reservas {
    constructor(
        public hab: number,
        public entrada: Date,
        public nif: string,
        public precio: number,
        public rutaPdf: string,
        public opciones: string
    ) {}
}

```

3. Ahora debemos tocar ambos servicios (Clientes y Reservas)
- En islantilla_spring/islantilla_angular/src/app/serices/clientes.service.ts
```ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Clientes } from '../models/clientes.model';

@Injectable({
  providedIn: 'root',
})
export class ClientesService {
  // Metemos el HttpClient para enlazar con el endpoint
  constructor(private http: HttpClient) {}

  // Método para agregar clientes
  addCliente(cliente: Clientes) {
    const url = `http://localhost:8100/clientes/insertar/${cliente.nif}/${cliente.nombre}/${cliente.edad}/${cliente.sexo}`;
    return this.http.post(url, {});
  }

  public getClientes(): Observable<Clientes[]> {
    const baseUrl = 'http://localhost:8100/clientes';
    return this.http.get<Clientes[]>(baseUrl + 'consultar');
  }
}
```

- En islantilla_spring/islantilla_angular/src/app/serices/reservas.service.ts
```ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reservas } from '../models/reservas.model';

@Injectable({
    providedIn: 'root'
})
export class ReservaService {
    private baseUrl = 'http://localhost:8100/reservas/';

    constructor(private http: HttpClient) {}

    public createReserva(reserva: Reservas): Observable<Reservas> {
        const url = `${this.baseUrl}insertar/${reserva.hab}/${reserva.entrada.toISOString().split('T')[0]}/${reserva.nif}/${reserva.precio}/${reserva.rutaPdf}/${reserva.opciones}`;
        return this.http.post<Reserva>(url, null); 
        // Pasamos 'null' como body ya que todos los datos van en la URL.
    }
}

```

4. Ahora definimos un formulario dentro del componente formulario_clientes
- En islantilla_spring/islantilla_angular/src/app/formularios-reservas/formularios-reservas.component.ts
```ts
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ClientesService } from '../services/clientes.service';
import { ReservaService } from '../services/reservas.service';
import { Clientes } from '../models/clientes.model';
import { Reservas } from '../models/reservas.model';

@Component({
  selector: 'app-formularios-reservas',
  templateUrl: './formularios-reservas.component.html',
  styleUrls: ['./formularios-reservas.component.css']
})


export class FormulariosReservasComponent implements OnInit {
  clientes: Clientes[] = [];
  reserva: Reservas = new Reservas(0, new Date(), '', 0, '', '');

  constructor(
      private clienteService: ClientesService,
      private reservaService: ReservaService
  ) {}

  ngOnInit() {
      this.clienteService.getClientes().subscribe(clientes => {
          this.clientes = clientes;
      });
  }

  onSubmit() {
      this.reservaService.createReserva(this.reserva).subscribe(result => {
          console.log('Reserva creada:', result);
          // Aquí puedes manejar acciones posteriores a la creación de la reserva
      });
  }
}

```

5. Ahora montamos el formulario en la capa vista del componente:
- En islantilla_spring/islantilla_angular/src/app/formularios-clientes/formularios-reservas.component.html
```html
<p>formularios-reservas works!</p>

<div class="container mt-3">
    <h2>Crear Reserva</h2>
    <form (ngSubmit)="onSubmit()">
        <!-- Número de Habitación -->
        <div class="mb-3">
            <label for="hab" class="form-label">Número de Habitación</label>
            <input type="number" class="form-control" id="hab" ngModel name="hab" required>
        </div>

        <!-- Fecha de Entrada -->
        <div class="mb-3">
            <label for="entrada" class="form-label">Fecha de Entrada</label>
            <input type="date" class="form-control" id="entrada" ngModel name="entrada" required>
        </div>

        <!-- Cliente (NIF y Nombre) -->
        <div class="mb-3">
            <label for="cliente" class="form-label">Cliente</label>
            <select class="form-select" id="cliente" ngModel name="nif" required>
                <option *ngFor="let cliente of clientes" [value]="cliente.nif">{{ cliente.nif }} - {{ cliente.nombre }}</option>
            </select>
        </div>

        <!-- Precio -->
        <div class="mb-3">
            <label for="precio" class="form-label">Precio</label>
            <input type="number" class="form-control" id="precio" ngModel name="precio" required>
        </div>

        <!-- Ruta PDF -->
        <div class="mb-3">
            <label for="rutaPdf" class="form-label">Ruta PDF</label>
            <input type="text" class="form-control" id="rutaPdf" ngModel name="rutaPdf">
        </div>

        <!-- Opciones -->
        <div class="mb-3">
            <label for="opciones" class="form-label">Opciones</label>
            <input type="text" class="form-control" id="opciones" [(ngModel)]="reserva.opciones" name="opciones">
        </div>

        <!-- Botón de Envío -->
        <button type="submit" class="btn btn-primary">Crear Reserva</button>
    </form>
</div>
```

6. Agregamos el Módulo HTTPClientModule en el módulo principal:
- En islantilla_spring/islantilla_angular/src/app/app.module.ts
```ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormulariosClientesComponent } from './formularios-clientes/formularios-clientes.component';
import { FormulariosReservasComponent } from './formularios-reservas/formularios-reservas.component'; // 


@NgModule({
  declarations: [
    AppComponent,
    FormulariosClientesComponent,
    FormulariosReservasComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

```

7. Ya solo nos queda agregarlo a la vista de la aplicación angular:
- En islantilla_spring/islantilla_angular/src/app/app.component.html
```html
<!-- Toolbar -->
<div class="toolbar" role="banner">
  <!-- //... -->
  <span>¡Saludos desde Symfony 6 y Angular 16!</span>
    <!-- //... -->
</div>

<section class="w-50 p-3 m-5">
<app-formularios-reservas></app-formularios-reservas>
</section>
```


8. Para visualizarlo, abrirmos el servidor:
```console
cd islantilla_spring/islantilla_angular
ng serve
# Y lo veremos en el navegador: http://localhost:4200
```


## Capitulo 5 - Angular 17 (EXEX)
[Tabla de contenidos](#tabla-de-contenidos)

> IMPORTANTE: Vamos a usar Angular 17.3.1
```console
sudo npm uninstall -g @angular/cli
sudo npm install -g @angular/cli@latest
sudo npm cache verify
ng version
```

1. Instalamos una aplicación Angular y los componentes necesarios:
```console
cd ~/Documents/workspace-sts/elex
ng new elex_angular_v17
cd elex_angular_v17

npm install bootstrap@5
ng generate component formularios-tipos
cd src/app/formularios-tipos
ng generate class models/formularios-tipos --type=model
ng generate service services/formularios-tipos

# IMPORTANTE: crear el archivo A MANO app.module.ts
cd ~/Documents/workspace-sts/elex/elex_angular_v17/src/app
touch app.module.ts
```

2. Ahora metemos boostrap:
- En angular.json
```json
"styles": [
  "node_modules/bootstrap/dist/css/bootstrap.min.css",
  "src/styles.css"
],
```

3. El resto de pasos es muy similar a lo ya visto...


## Capitulo 6 - Spring Security
[Tabla de contenidos](#tabla-de-contenidos)

1. Lo primero, añadir la dependencia en el pom.xml
```xml
<!-- SpringBoot Security -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
```

2. Instalamos la dependencia con Botón derecho > Maven > Build (clean install)
3. Nos creamos un archivo de configuración para Spring Security, lo suyo en la carpeta config.
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/config/SpringSecurityConfig.java
```java
package com.soltel.islantilla.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    // vamos a levantar la mano para el acceso
    // Evitamos problemas con swagger y el front (Angular)
    @Bean
    public SecurityFilterChain filtradoSeguridad (HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(request -> new CorsConfiguration()
                .applyPermitDefaultValues()))

            // CSRF controla las llamadas del Front
            .csrf(csrf -> csrf.disable())

            // Definimos los prefijos de los endpoints autorizados
            .authorizeHttpRequests(auth -> auth.
                requestMatchers("/clientes/**", "/reservas/**").permitAll()
                .anyRequest().authenticated())

            // Tras logarse con el formulario, saltar a un endpoint
            .formLogin(form -> form.defaultSuccessUrl("/menu",true));
        return http.build();
    }

    // Elegimos el encriptado de la contraseña
    @Bean
    public PasswordEncoder encriptado() {
        return new BCryptPasswordEncoder();
    }

    // Para definir credenciales de acceso
    @Bean
    public UserDetailsService credenciales (PasswordEncoder encriptado) {
        UserDetails usuarioPrincipal = User.builder()
            .username("soltel")
            .password(encriptado.encode("admin"))
            .roles("ADMIN")
            .build();
            
        return new InMemoryUserDetailsManager(usuarioPrincipal);
    }
}

```


4. Nos creamos un archivo de configuración para CORS, para la gestión de accesos del frontend, en la carpeta config.
- En workspace-sts/islantilla/src/main/java/com/soltel/islantilla/config/CorsConfig.java
```java
package com.soltel.islantilla.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Digo cuales van a ser los endpoint mapeados
        registry.addMapping("/clientes/**")
            .allowedOrigins("http://localhost:4200")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true);
        
        registry.addMapping("/reservas/**")
            .allowedOrigins("http://localhost:4200")
            .allowedMethods("GET", "POST", "PUT")
            .allowedHeaders("*")
            .allowCredentials(true);

        // Otra opción sería derivar los endpoints de /api
    }
}

```


```java
#...
```

