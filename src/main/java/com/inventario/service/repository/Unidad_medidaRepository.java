package com.inventario.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.inventario.service.models.Unidad_medida;

public interface Unidad_medidaRepository extends CrudRepository<Unidad_medida, Integer>{
	
	/**
	 * Unidad de medida DAO
	 */
	
	@Query(value="SELECT EXISTS(SELECT u.* FROM unidad_medida u WHERE LOWER(u.unidad_medida) = LOWER(?1) AND u.cantidad = ?2)", nativeQuery = true)
	boolean ifExistsStockByNameandCod(String nombre, int cantidad);
	
	@Query(value="SELECT EXISTS(SELECT u.* FROM unidad_medida u WHERE LOWER(u.unidad_medida) = LOWER(?1))", nativeQuery = true)
	boolean ifExistsStockByName(String nombre);
	
	@Query(value="SELECT EXISTS(SELECT u.* FROM unidad_medida u WHERE u.cantidad = ?2)", nativeQuery = true)
	boolean ifExistsStockByCod(int codigo);
	
	@Query(value="SELECT u.* FROM unidad_medida u WHERE LOWER(u.unidad_medida) = LOWER(?1) AND u.cantidad = ?2", nativeQuery = true)
	Unidad_medida getIdByNameCod(String nombre, int cantidad);
	
	@Query(value="SELECT u.* FROM unidad_medida u WHERE u.codigo = ?1", nativeQuery = true)
	Unidad_medida getById(int codigo);
}
