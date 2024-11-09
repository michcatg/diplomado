package com.iis.unam.coordlib_service.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Autor extends Persona{
	@NotBlank(message="Debe de indicar el rol")
	@Pattern(regexp="^(Autor|Coautor|Coordinador)$",message="Debe de seleccionar un rol válido: Autor|Coautor|Coordinador")
	private String rol;
}
