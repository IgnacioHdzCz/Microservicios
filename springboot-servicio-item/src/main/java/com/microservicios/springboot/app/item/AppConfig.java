package com.microservicios.springboot.app.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *Caracteristicas de la anotacion @Configuration permite
 *crear bean y registrarlos en el contenedor de spring 
 *utilizando metodos y la anotacion bean
 */
@Configuration
public class AppConfig {
	
	@Autowired
	private RestTemplate clienteRest;
	
	/**
	 * El objeto que se retorna se guarda en el contenedor
	 * con la anotacion @Bean
	 * Lo podria regresar con el nombre del metodo
	 * pero le ponemos el nombre clienteRest
	 * RestTemplate es un cliente API Rest
	 * cliente HTTP
	 * Clienre para poder acceder a los recueros de otros MS
	 */
	
	//Load Balanced para el balanceo de cargas
	//con Rest Template
	@Bean("clienteRest")
	@LoadBalanced
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}

}
