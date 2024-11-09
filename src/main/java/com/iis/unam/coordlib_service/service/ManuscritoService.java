package com.iis.unam.coordlib_service.service;

import com.iis.unam.coordlib_service.domain.Manuscrito;
import com.iis.unam.coordlib_service.domain.Formato;
import com.iis.unam.coordlib_service.domain.Autor;
import com.iis.unam.coordlib_service.domain.Dictamen;

public interface ManuscritoService {
  Manuscrito registrarDictamen(
		String id, Dictamen dictamen
  );
}