package com.iis.unam.coordlib_service.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona {
	
	@NotBlank(message="Debe de proporcionar el nombre")
	private String nombres;
	@NotBlank(message="Debe de proporcionar el apellido")
	private String primerApellido;
	private String segundoApellido;
	@NotBlank(message="Debe de indicar su correo institucional")
	@Email(message="Debe de ingresar un correo electrónico válido")
	private String correo;
}
