package com.inventario.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.inventario.service.models.Stock_producto;

public interface Stock_productoRepository extends CrudRepository<Stock_producto, Integer>{
	
	/**
	 * Stock producto DAO
	 */
	
	@Query(value="SELECT EXISTS(SELECT s.* FROM stock_producto s WHERE s.codigo=?1)", nativeQuery=true)
	boolean findBycod_stock(int cod_stock);
	
	@Query(value="SELECT EXISTS(SELECT s.* FROM stock_producto s WHERE LOWER(s.nombre)=LOWER(?1) AND cod_local=?2)", nativeQuery = true)
	boolean ifExistsStock(String name, int cod_local);
	
	@Query(value="SELECT EXISTS(SELECT s.* FROM stock_producto s WHERE s.codigo = ?1)", nativeQuery = true)
	boolean ifExistsStockById(int codigo);
	
	@Query(value="SELECT EXISTS(SELECT s.nombre FROM stock_producto s WHERE LOWER(s.nombre) = LOWER(?1))", nativeQuery = true)
	boolean ifExistsStockByName(String nombre);
	
	@Query(value="SELECT s.codigo FROM stock_producto s WHERE LOWER(s.nombre) = LOWER(?1)", nativeQuery = true)
	int StockById(String nombre);
	
	@Query(value="SELECT s.* FROM stock_producto s WHERE LOWER(s.nombre) = LOWER(?1)", nativeQuery = true)
	Stock_producto StockByname(String nombre);
	
	@Query(value="SELECT s.* FROM stock_producto s WHERE s.codigo = ?1", nativeQuery = true)
	Stock_producto getStock(int codigo);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE stock_producto SET cantidad_total=?1 WHERE codigo=?2", nativeQuery = true)
	void updateCantidad_total(int cantidad, int codigo);
	
	@Query(value="SELECT s.cantidad_total FROM stock_producto s WHERE s.codigo=?1", nativeQuery = true)
	int getCantidad_actual(int codigo);
	
	@Query(value="SELECT s.existencia_minima FROM stock_producto s WHERE s.codigo= ?1", nativeQuery = true)
	int getExistenciaMinima(int codigo);
	
	@Query(value="SELECT * FROM stock_producto WHERE cod_local=?1", nativeQuery = true)
	List<Stock_producto> getAllStockById(int codigo);
}
