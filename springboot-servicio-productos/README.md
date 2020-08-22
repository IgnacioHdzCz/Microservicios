# Microservicios
Curso de Microservicios

Para esta primera parte se van a crear el microservicio Servicio-Productos, se hace uso del Startert Project de Spring Tool Suite
![Captura1](https://user-images.githubusercontent.com/41167366/89090356-10cab100-d368-11ea-8210-e03f0c937237.PNG)


Se agregan las dependencias que se ve en la figura

![Captura2](https://user-images.githubusercontent.com/41167366/89090820-ef1ef900-d36a-11ea-9f53-fbf60650bfb0.PNG)

Se genera una estructura de paquetes y se crea uno el nombre con com.microservicios.springboot.app.productos.models.entity y se agrega una clase Producto.
![Captura3](https://user-images.githubusercontent.com/41167366/89090826-f0e8bc80-d36a-11ea-9708-af0337f18226.PNG)

Se crea la clase producto  y se agregan los siguientes atributos  
private Long id; private String nombre; private Double precio; @Column(name="create-at")
![Captura4](https://user-images.githubusercontent.com/41167366/89091108-8a649e00-d36c-11ea-9f33-c87251a7c6c9.PNG)

5.- Creamos un paquete que contendra la interfaz del repositorio com.microservicios.springboot.app.productos.models.dao

![Captura6](https://user-images.githubusercontent.com/41167366/89134400-82cb0380-d4ea-11ea-9ed0-e9d37c75c46a.PNG)


6.- Creamos la interfaz ProductoDAO
![Captura7](https://user-images.githubusercontent.com/41167366/89134440-e5bc9a80-d4ea-11ea-8322-6644d795a4ed.PNG)

7.- Esta interfaz va extender de CRUDREPOSITORY e utiliza genericos declaramos el primer tipo que es Producto y el ID. Se esta creando un repositorio apartir de la
clase entity que es producto
CrudRepository ya tiene varios metodos que nos permiten tener la funcionalidad de un CRUD.
Con esta configuracion ya se puede utilizar ProductoDao directamente pero por buenas practicas se recomienda implementar una clase SERVICE, es una fachada para desacoplar
el DAO del Controlador.
![Captura5](https://user-images.githubusercontent.com/41167366/89135411-fe30b300-d4f2-11ea-8f15-ae82260fb594.PNG)


8.- Vamos a crear el servicio, renombramos un paquete con el siguiente nombre com.microservicios.springboot.app.productos.models.service
![Captura9](https://user-images.githubusercontent.com/41167366/89134751-3fbe5f80-d4ed-11ea-9524-885f0c048510.PNG)

9.- Creamos una clase que va implementar esa interfaz ProductoServiceImpl.

![Captura10](https://user-images.githubusercontent.com/41167366/89134812-b2c7d600-d4ed-11ea-88b2-f16fcc1cc757.PNG)


10.- Las configuraciones para esta implementaciones son las siguientes
agregamos la anotacion @Service, @Transactional(readOnly=true)
![Captura12](https://user-images.githubusercontent.com/41167366/89134882-56b18180-d4ee-11ea-98c9-31610c144cab.PNG)

11.- Inyectar la interfaz del tipo ProductoDAO, esta clase debe tener las siguientes configuraciones

![Captura13](https://user-images.githubusercontent.com/41167366/89135115-bf99f900-d4f0-11ea-8a4d-e4f45b6b61d8.PNG)

12.- Vamos a crear la clase Controller que va estar en el siguiente paquete

![Captura14](https://user-images.githubusercontent.com/41167366/89240083-a6607d80-d5c0-11ea-88ff-4afe9c02978f.PNG)


13.- Lo primero que se debe hacer es anotar la clase con la anotacion @Controller, los MS trabajan con API REST ah si que es necesario agregar esta anotacion

Esa anotacion lo que hace es convertir a JSON lo que retornan los metodos Handler, un metodo
handler que este mapeado a la URI, Los metodos listar() son los que nos van a regresar
una lista de productos, al momento de que en la uri venga la ruta absulta
ruta/listar
Para hacer esto mas dinamico podemos agregar al @GetMapping un parametro que vamos a tomar
como variable para ir a buscar a la BD
El metodo detalle recibe como parametro en la uri un id y con @PathVariable
podemos obtener ese id.
![Captura16](https://user-images.githubusercontent.com/41167366/89243351-5a660680-d5c9-11ea-8fb3-6c20703c7efe.PNG)
![Captura17](https://user-images.githubusercontent.com/41167366/89243353-5b973380-d5c9-11ea-8df5-0325dbacb687.PNG)


14 .- Probar API productos con POSTMAN
Vamos a crear un archivo que va contener las sentencias SQL, es importante el nombre del archivo debe llamarse import.sql.
Ah si queda en la estructura de las carpetas
![Captura18](https://user-images.githubusercontent.com/41167366/89715677-f8acf000-d96c-11ea-9efd-eeaf32a5829f.PNG)

15.- Levantamos el servicio y verificamos que en los logs se haya ejecutado una sentencia SQL.

![Captura19](https://user-images.githubusercontent.com/41167366/89715744-81c42700-d96d-11ea-81cc-10a241408c00.PNG)

Ingresamos a la siguiente ruta localhost:8010/listar para visualizar los datos.
![Captura20](https://user-images.githubusercontent.com/41167366/89715817-352d1b80-d96e-11ea-9d34-3ae3e8ac8827.PNG)

Para visualizar los datos por ID
![image](https://user-images.githubusercontent.com/41167366/89715964-18451800-d96f-11ea-83ff-c3a0136457e3.png)

Verificando en Postman
Listar datos
![Captura21](https://user-images.githubusercontent.com/41167366/89715897-a967bf00-d96e-11ea-801f-b02c38735fdd.PNG)
Por Id
![Captura23](https://user-images.githubusercontent.com/41167366/89715983-3e6ab800-d96f-11ea-8abc-31d2920a391f.PNG)

*****************************************
Usando cliente REST Feign para consumir la API productos

Libreria Feign forma de implememtar cliet HTTP, 
Agregar la libreria cloud rounting --> Feign--> Spring Cloud 
Anotar la clase public class SpringbootServicioItemApplication con la anotacion
@EnableFeignClients
Despues de agregar esa anotacion, creamos un paquete y ponemos una intefaz con las siguientes configuraciones


![Captura42](https://user-images.githubusercontent.com/41167366/90838857-9ca67c00-e31b-11ea-9955-cd1e29ed16a7.PNG)

![Captura43](https://user-images.githubusercontent.com/41167366/90839198-7f25e200-e31c-11ea-8950-195b576a644a.PNG)


![Captura44](https://user-images.githubusercontent.com/41167366/90839869-2bb49380-e31e-11ea-9e1f-3f65777c5b3d.PNG)



![Captura45](https://user-images.githubusercontent.com/41167366/90841088-5fdd8380-e321-11ea-9d29-7b9317cf1f28.PNG)

![Captura46](https://user-images.githubusercontent.com/41167366/90841138-800d4280-e321-11ea-8159-cc9207e03aac.PNG)


// Agregamos la siguiente dependencia de ribbon
	<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-ribbon -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
    <version>2.2.3.RELEASE</version>
</dependency>

Y configuramos la interfaz ProductoClienteRest quedano de la siguiente forma




![Captura47](https://user-images.githubusercontent.com/41167366/90841291-e98d5100-e321-11ea-8ab9-98f21b5c319a.PNG)

Servicios Productos debe tener mas de una instancia desplegada en diferentes puertos
y con el balanceador de cargas Ribbon seleccionar la mejor.


Vamos a desacoplar las configuraciones que tenemos en la clase
empezando

![Captura48](https://user-images.githubusercontent.com/41167366/90844174-ed70a180-e328-11ea-9a2e-b2a44d9901c7.PNG)
![Captura49](https://user-images.githubusercontent.com/41167366/90844223-0b3e0680-e329-11ea-9c4d-139451246482.PNG)
![Captura50](https://user-images.githubusercontent.com/41167366/90844311-3cb6d200-e329-11ea-898b-dad6dc28c838.PNG)

Para arrancar dos instancias en diferentes puertos hacemos lo siguiente


![Captura51](https://user-images.githubusercontent.com/41167366/90844822-69b7b480-e32a-11ea-9148-9b26e75a52ce.PNG)
![Captura52](https://user-images.githubusercontent.com/41167366/90844828-6c1a0e80-e32a-11ea-8d80-3486ef4c7bec.PNG)

Para levantar las dos instancias en la segunda no ponemos nada de ningun puerto
