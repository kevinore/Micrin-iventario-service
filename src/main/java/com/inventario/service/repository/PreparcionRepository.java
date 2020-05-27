package com.inventario.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.inventario.service.models.Preparacion;

public interface PreparcionRepository extends CrudRepository<Preparacion, Integer>{
	
	/**
	 * Preparacion DAO
	 */
	
	@Query(value="SELECT EXISTS(SELECT p.* FROM preparacion p WHERE p.id=?1)", nativeQuery = true)
	boolean ifExistsPreparacion(int codigo);

}
