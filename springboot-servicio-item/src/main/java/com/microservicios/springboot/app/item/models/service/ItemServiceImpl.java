package com.microservicios.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservicios.springboot.app.item.models.Item;
import com.microservicios.springboot.app.item.models.Producto;

/**
 * @author Ignacio
 *Fachada para acceder a los datos @Service, los datos
 *se van a obtener atravez de una API Rest
 */

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {
	
	
	@Autowired
	private RestTemplate clienteRest;
	
	/**
	 * Obtener el listado de Producto
	 * Utilizar ClienteRest
	 * Primero una ruta
	 * Segundo el tipo que deseamos obtener, no se puede obtener una lista
	 * podemos usar un arreglo de productos
	 * Atraves del clienteRest obtenemos el objeto, pasamos la ruta
	 * y el tipo que deseamos obtener
	 */

	/**
	 * Esto retorna un arreglo de productos pero queremos un List, hay 
	 * que convertirlo a una Lista, se utiliza Arrays.asLit
	 */
	
	/**
	 * getForObject("http://localhost:8010/listar",Producto[].class ));
	 * localhost:8010 se cambia por el microservicio a consumir
	 * 
	 */
	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(clienteRest.
				getForObject("http://servicio-productos/listar",Producto[].class ));
		/*
		 * productos trae una lista de Producto y al querer regresarlo 
		 * marca error por que no son compatibles Producto-Item
		 * La accion es transformar productos a item
		 * Se puede usar el api stream, los objetos de tipo List
		 * tienen el metodo stream para convertir la lista a un flujo
		 */
		return productos.stream()
				.map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	/*
	 * getForObject("http://localhost:8010/ver/{id}", 
	 */
	@Override
	public Item findById(Long id, Integer cantidad) {
		//Obtener un producto por el id
		Map<String,String> pathVariables = new HashMap<String,String>();
				pathVariables.put("id", id.toString());
				
		Producto producto = clienteRest.
				getForObject("http://servicio-productos/ver/{id}", 
						Producto.class,
						pathVariables);
		return new Item(producto,cantidad) ;
	}

}
