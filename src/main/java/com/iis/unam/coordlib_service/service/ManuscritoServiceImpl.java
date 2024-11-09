package com.iis.unam.coordlib_service.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iis.unam.coordlib_service.domain.Dictamen;
import com.iis.unam.coordlib_service.domain.Manuscrito;
import com.iis.unam.coordlib_service.repository.ManuscritoRepository;

@Service
public class ManuscritoServiceImpl implements ManuscritoService {
	
	@Autowired
	private ManuscritoRepository manuscritoRepository;

	@Override
	public Manuscrito registrarDictamen(String id, Dictamen dictamen) {
		// validacion manuscrito existente
		Optional<Manuscrito> manuscritoExistente = manuscritoRepository.findById(id);
		if (manuscritoExistente.isPresent()) {
			Manuscrito manuscritoActualizar = manuscritoExistente.get();
			manuscritoActualizar.getDictamenes().add(dictamen);
			manuscritoRepository.save(manuscritoActualizar);
			return manuscritoActualizar;
		}
		return null;
	}
}
