package com.iis.unam.coordlib_service.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dictamen {

	@NotBlank(message="Debe de proporcionar un dictamen")
	@Pattern(regexp="Positivo|Negativo|Condicionado",message="El tipo de publicación no es válido. Los posibles tipos de publicación son: Positivo | Negativo | Condicionado")
	private String dictamen;
	private String observaciones;
	@NotNull(message="Debe de proporcionar un dictaminador")
	private Persona dictaminador = new Persona();
	
}
