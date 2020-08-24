package com.microservicios.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservicios.springboot.app.item.models.Item;
import com.microservicios.springboot.app.item.models.Producto;

//@FeignClient(name="servicio-productos",url="localhost:8010")
@FeignClient(name="servicio-productos")
public interface ProductoClienteRest {
	
	//Esta es la implementacion de un cliente REST
	//EndPoint
	@GetMapping("/listar")
	public List<Producto> listar();
		
	@GetMapping("/ver/{id}")
	
	public Producto detalle(@PathVariable Long id); 
}
