package com.inventario.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.inventario.service.models.Plato;
import com.inventario.service.models.Stock_producto;

public interface PlatoRepository extends CrudRepository<Plato, Integer>{
	
	/**
	 * Plato DAO
	 */
	
	@Query(value="SELECT EXISTS(SELECT p.* FROM plato p WHERE LOWER(p.nombre)=LOWER(?1) AND p.cod_local=?2)", nativeQuery = true)
	boolean ifExistsPlato(String plato, int code);
	
	@Query(value="SELECT EXISTS(SELECT p.* FROM plato p WHERE p.codigo=?1)", nativeQuery = true)
	boolean ifExistsPlatoByid(int plato);
	
	@Query(value="SELECT EXISTS(SELECT p.* FROM plato p WHERE LOWER(p.nombre)=LOWER(?1))", nativeQuery = true)
	boolean ifExistsPlatoByName(String plato);
	
	@Query(value="SELECT p.codigo FROM plato p WHERE LOWER(p.nombre)=LOWER(?1)", nativeQuery = true)
	int PlatoByid(String plato);
	
	@Query(value="SELECT p.* FROM plato p WHERE p.codigo = ?1", nativeQuery = true)
	Plato findPlatoByNum(int codigo);
	
	@Query(value="SELECT p.* FROM plato p WHERE LOWER(p.nombre)=LOWER(?1)", nativeQuery = true)
	Plato getPlatoByName(String plato);
	
	@Query(value="SELECT * FROM plato WHERE cod_local=?1", nativeQuery = true)
	List<Plato>findAllStockByid(int codigo);
	
	
	
}
