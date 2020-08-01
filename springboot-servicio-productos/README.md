# Microservicios
Curso de Microservicios

Para esta primera parte se van a crear el microservicio Servicio-Productos, se hace uso del Startert Project de Spring Tool Suite
![Captura1](https://user-images.githubusercontent.com/41167366/89090356-10cab100-d368-11ea-8210-e03f0c937237.PNG)


Se agregan las dependencias que se ve en la figura

![Captura2](https://user-images.githubusercontent.com/41167366/89090820-ef1ef900-d36a-11ea-9f53-fbf60650bfb0.PNG)

Se genera una estructura de paquetes y se crea uno el nombre con com.microservicios.springboot.app.productos.models.entity y se agrega una clase Producto.
![Captura3](https://user-images.githubusercontent.com/41167366/89090826-f0e8bc80-d36a-11ea-9708-af0337f18226.PNG)

Se crea la clase producto  y se agregan los siguientes atributos  
  
  private Long id;	
	private String nombre;
	private Double precio;
	@Column(name="create-at")
![Captura4](https://user-images.githubusercontent.com/41167366/89091108-8a649e00-d36c-11ea-9f33-c87251a7c6c9.PNG)



