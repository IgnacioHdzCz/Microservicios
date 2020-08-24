package com.microservicios.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.springboot.app.item.models.Item;
import com.microservicios.springboot.app.item.models.service.ItemService;

@RestController
public class ItemController {
/*
 * Cuando configuramos  AppConfig con la anotacion
 * LoadBalanced y modificamos la clase ItemServiceImpl
 * cambiamos el Qualifier por 
 * serviceRestTemplate
 * 
 */
	
	@Autowired
	//@Qualifier("serviceFeign")
	//Se cambia el calificador por restTemplate
	@Qualifier("serviceRestTemplate")
	private ItemService itemService;
	
	/**
	 * Agregar los metodos Handler para listar los item
	 * y para buscar por Id
	 */
	
	/*
	 * List<Item> y detalle son end-points
	 */
	
	// esto es un endpoint
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll();	
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id,
			@PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
		
	}
}
