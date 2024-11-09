package com.iis.unam.coordlib_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
			version = "v1",
			title = "Dictaminación de manuscritos - Microservice Endpoints", 
			description = "Definición de los Endpoints para "
					+ "registro y consulta de dictámenes de manuscritos ", 
			contact = @Contact(
				name = "Michelle Caterine García Velasco", 
				url = "https://www.iis.unam.mx/sobre-el-instituto/directorio/departamento-de-computo/garcia-velasco-michelle-caterine/", 
			email = "michelle.garcia@sociales.unam.mx")))
public class OpenApiConfig {

}