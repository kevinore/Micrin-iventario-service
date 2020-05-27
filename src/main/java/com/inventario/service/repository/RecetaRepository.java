package com.inventario.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.inventario.service.models.Receta;

public interface RecetaRepository extends CrudRepository<Receta, Integer> {
	
	/**
	 * Receta DAO
	 */
	
	@Query(value="SELECT r.codigo_spro FROM receta r WHERE codigo_plato = ?1", nativeQuery = true)
	List<Integer> selectDataFromReceta(int codigo);
	
	@Query(value="SELECT r.cantidadxplato FROM receta r WHERE r.codigo_spro = ?1 AND r.codigo_plato = ?2", nativeQuery = true)
	int selectCantida(int codigo, int codigo_plato);
	
	@Query(value="SELECT EXISTS(SELECT r.* FROM receta r WHERE r.id=?1)", nativeQuery = true)
	boolean ifExistsReceta(int codigo);
	
	
}
