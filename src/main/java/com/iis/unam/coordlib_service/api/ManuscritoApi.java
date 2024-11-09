package com.iis.unam.coordlib_service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestController;

import com.iis.unam.coordlib_service.domain.Dictamen;
import com.iis.unam.coordlib_service.domain.Manuscrito;
import com.iis.unam.coordlib_service.repository.ManuscritoRepository;
import com.iis.unam.coordlib_service.service.ManuscritoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path="api/manuscritos", produces="application/json")
@CrossOrigin(origins="*")

public class ManuscritoApi {
  @Autowired
  private ManuscritoRepository manuscritoRepository;
  @Autowired
  private ManuscritoService manuscritoService;

	@Operation(summary="Obtiene la lista de todos los manuscritos registrados")
	@GetMapping
	public List<Manuscrito> obtenerManuscritos() {
		return manuscritoRepository.findAll();
	}

	@Operation(summary="Permite registrar un manuscrito")
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Manuscrito crearManuscrito(@Valid @RequestBody Manuscrito manuscrito) {
		return manuscritoRepository.save(manuscrito);
	}
	
	@GetMapping("{id}")
	@Operation(summary="Obtiene un manuscrito con el identificador dado")
	@Parameter(name="id",description="Identificador del Manuscrito",required=true)
	public ResponseEntity<Manuscrito> obtenerManuscritoPorId(@PathVariable("id") String id) {
		Optional<Manuscrito> manuscrito = manuscritoRepository.findById(id);
		if (manuscrito.isPresent()) {
			return new ResponseEntity<>(manuscrito.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Operation(summary="Registra un dictamen del manuscrito con su identificador dado")
	@PutMapping(path="{id}/dictamen", consumes="application/json")
	@Parameter(name="id",description="Identificador del Manuscrito",required=true)
	public ResponseEntity<Manuscrito> registrarDictamen(
		@PathVariable("id") String id, @Valid @RequestBody Dictamen dictamen) {
		Manuscrito manuscritoActualizado = manuscritoService.registrarDictamen(id, dictamen);
		if (manuscritoActualizado != null) {
			return new ResponseEntity<>(manuscritoActualizado, HttpStatus.OK) ;
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}