package com.iis.unam.coordlib_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.iis.unam.coordlib_service.domain.Manuscrito;
import com.iis.unam.coordlib_service.domain.Formato;
import com.iis.unam.coordlib_service.domain.Autor;

@Data
@NoArgsConstructor
public class RegistroManuscritoRequest {
	
	@NotNull
	@Valid
	private Manuscrito manuscrito;
	@NotNull
	@Valid
	private Formato formato;
  @NotNull
	@Valid
	private Autor autor;
}