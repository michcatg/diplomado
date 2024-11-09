package com.iis.unam.coordlib_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iis.unam.coordlib_service.domain.Manuscrito;

public interface ManuscritoRepository 
	extends MongoRepository<Manuscrito, String>{

}

