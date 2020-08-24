package com.microservicios.springboot.app.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.springboot.app.productos.models.entity.Producto;
import com.microservicios.springboot.app.productos.models.service.IProductoService;

@RestController
//Los MS trabajan con REST
// Convertir a JSON lo que retorna los metodos handler
// un metodo handler que esta mapeado a una ruta URL retorna una lista
// de productos
//Retornar el contenido de nuestro metodo handler 
//Controlador Rest
public class ProductoController {
	
	@Autowired
	private Environment env;
	//Value se utiliza para inyectar valor que
	//tenemos en los proporties
	@Value("${server.port}")
	private Integer port;
	@Autowired
	private IProductoService productoService;
	
	//metodos handler
	//El tipo que van a convertir el Producto en una lista
	//Se mapea atraves de una ruta con GetMapping
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(producto -> {
			// ya no va la siguiente linea se cambia por  
					//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
					producto.setPort(port);
					return producto;
				}).collect(Collectors.toList());
	}

	@GetMapping("/ver/{id}")
	// Con PathVariable automaticamente
	// pasamos el argumento que venga en la URL
	// al metodo en este caso se llama ID, con eso vamos a buscar a la BD mediante el SERVIECE
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		//return productoService.findById(id);
		return producto;
	}

}
