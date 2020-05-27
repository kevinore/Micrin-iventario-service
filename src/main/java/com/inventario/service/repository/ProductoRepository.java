package com.inventario.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventario.service.models.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{
	
	/**
	 * Producto DAO
	 */

}
