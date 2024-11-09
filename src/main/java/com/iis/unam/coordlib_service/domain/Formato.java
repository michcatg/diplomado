package com.iis.unam.coordlib_service.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Formato {
	
	@NotBlank(message="Debe de proporcionar al menos un formato")
	@Pattern(regexp="^(PDF|EPUB|Impreso)$",message="Los posibles formatos a elegir son PDF, EPUB o Impreso")
	private String formato;

}
