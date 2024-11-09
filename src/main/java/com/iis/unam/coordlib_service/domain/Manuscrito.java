package com.iis.unam.coordlib_service.domain;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="manuscritos")
public class Manuscrito {
	
	@Id
	@MongoId(FieldType.OBJECT_ID)
	@Schema(accessMode = AccessMode.READ_ONLY)
	private String id;
	@NotBlank(message="Debe de tener título")
	private String titulo;
	@NotBlank(message="Debe de tener un tipo de publicación")
	@Pattern(regexp="^(Libro|Cuaderno de investigación|Memoria de congresos o eventos)$",message="El tipo de publicación no es válido. Los posibles tipos de publicación son: Libro | Cuaderno de investigación | Memoria de congresos o eventos")
	private String tipoPublicacion;
	@NotEmpty(message="Debe seleccionar al menos un formato (PDF, EPUB o Impreso)")
	private Collection<Formato> formatos = new LinkedHashSet<>();
	@NotBlank(message="Debe proporcionar un breve perfil de la obra")
	private String perfil;
	@NotEmpty(message="Debe de indicar al menos un autor")
	private Collection<Autor> autores = new LinkedHashSet<>();
	@Hidden
	private Collection<Dictamen> dictamenes = new LinkedHashSet<>();
	
	@Schema(accessMode = AccessMode.READ_ONLY)
	@CreatedDate
	private LocalDateTime fechaCreacion;
	
	@Schema(accessMode = AccessMode.READ_ONLY)
	@LastModifiedDate
	private LocalDateTime fechaActualizacion;
}
