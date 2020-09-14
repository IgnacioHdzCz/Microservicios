package com.microservicios.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.cloud.openfeign.EnableFeignClients;

//import org.springframework.cloud.netflix.ribbon.RibbonClient;
@EnableEurekaClient
//Feign para apiRest
@EnableFeignClients
//Para habilitar clientes feign
@SpringBootApplication
//@RibbonClient(name="servicio-productos")
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
