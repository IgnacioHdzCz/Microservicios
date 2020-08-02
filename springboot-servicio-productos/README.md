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


8.- Vamos a crear el servicio, renombramos un paquete con el siguiente nombre com.microservicios.springboot.app.productos.models.service
![Captura9](https://user-images.githubusercontent.com/41167366/89134751-3fbe5f80-d4ed-11ea-9524-885f0c048510.PNG)

9.- Creamos una clase que va implementar esa interfaz ProductoServiceImpl.

![Captura10](https://user-images.githubusercontent.com/41167366/89134812-b2c7d600-d4ed-11ea-88b2-f16fcc1cc757.PNG)


10.- Las configuraciones para esta implementaciones son las siguientes
agregamos la anotacion @Service, @Transactional(readOnly=true)
![Captura12](https://user-images.githubusercontent.com/41167366/89134882-56b18180-d4ee-11ea-98c9-31610c144cab.PNG)

11.- Inyectar la interfaz del tipo IProductoDao.


