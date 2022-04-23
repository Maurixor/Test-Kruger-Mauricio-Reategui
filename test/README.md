
# Inventario de vacunación de empleados 

Implementación de backend para el manejo de inventario de vacunación de empleados, con roles de administrador y usuario.


## Autor

- [@Maurixor](https://github.com/Maurixor)


## Base de datos

Se requiere una base de datos PostgreSQL para el funcionamiento del programa, con una tabla llama "empleados".

En la consola psql, la tabla puede ser creada con el comando:

    CREATE TABLE empleados(cedula BIGINT PRIMARY KEY, nombres VARCHAR(255), apellidos VARCHAR(255), correoElectronico VARCHAR(255), fechaNacimiento DATE, direccion VARCHAR(255), telefonoMovil BIGINT, vacunado BOOLEAN, tipoVacuna VARCHAR(255), fechaVacuna DATE, numeroDosis BIGINT);

Además, se pueden insertar empleados usando el comando INSERT INTO como en el ejemplo a continuación:

    INSERT INTO empleados (cedula, nombres, apellidos, correoelectronico) VALUES (1725234403, 'Mauricio', 'Reategui', 'mauricio@hotmail.com');

La base de datos debe estar hosteada en el puerto local 5432.

En src/main/java/resources/application.properties hay algunos campos que podemos editar.

localhost contiene el numero del puerto, mauricioreategui es el nombre de la base de datos

    spring.datasource.url=jdbc:postgresql://localhost:5432/mauricioreategui

username es el usuario con el que loggeamos a PostgreSQL y password la contraseña


    spring.datasource.username=mauricioreategui
    spring.datasource.password=usetation98 
## Como ejecutar

Una vez la base de datos este en linea, ejecutamos TestApplication.java, localizado en src/main/java/com.kruger.test. El programa se encontrara en 

    http://localhost:8080/

Podemos accesarlo desde cualquier buscador.
El programa cuenta con dos controladores: AdministradorController y EmpleadoController. Los metodos de los controladores estan documentados con swagger open api. Para ver esta documentación, ejecutar el programa y en cualquier buscador ingresar la siguiente dirección:

    http://localhost:8080/swagger-ui.html
Desde aqui tambien podemos probar los distintos metodos, ingresando parámetros si es necesario.
## Detalles de implementación

Solo se implementa la parte de backend del programa. No contiene implementación de usuarios, pero si con lo demás especificado en el reto.
Se usa Spring Boot como framework, por lo cual se cuenta con los siguientes paquetes/capas en src/main/java/com.kruger.test:

Controladores:
- AdministradorController
- EmpleadoController
Servicios:
- AdministradorService
- EmpleadoService
Repositorio:
- EmpleadoRepository
Entidad:
- Empleado

Además, en la carpeta src/test/java/com.kruger.test se encuentran pruebas unitarias. Se implementaron algunas pruebas unitarias para EmpleadoService. Podemos ver los resultados de estas pruebas ejecutando:

    EmpleadoServiceTest.java

