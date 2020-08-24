package com.microservicios.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicios.springboot.app.productos.models.dao.ProductoDAO;
import com.microservicios.springboot.app.productos.models.entity.Producto;

//Se registra esta clase en spring como bean
@Service
//Despues de esto podemos  inyectar este Service en el controlador
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoDAO productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// productoDao es un bean e invocamos los metodos
		// retorna un iterable y agregamos un cast
		
		//iterable es una super interfaz de list
		//Iterable--> Collections-->List
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		//Esto va regresar un optional
		//es decir puede regresar un id de la base de datos
		//Si el objeto viene presente
		//sino se encuentra regresa un null
		return productoDao.findById(id).orElse(null);
	}

}
