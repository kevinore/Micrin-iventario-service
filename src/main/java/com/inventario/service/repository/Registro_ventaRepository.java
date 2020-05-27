package com.inventario.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.inventario.service.models.Registro_venta;

public interface Registro_ventaRepository extends CrudRepository<Registro_venta, Integer>{
	
	/**
	 * Registro venta DAO
	 */
	
	@Query(value="SELECT EXISTS(SELECT rg.* FROM registro_venta rg WHERE rg.codigo=?1)", nativeQuery=true)
	boolean ifexistsBycodigo(int cod_stock);
	
	@Query(value="SELECT rg.* FROM registro_venta rg WHERE rg.codigo=?1", nativeQuery=true)
	Registro_venta getRegistro(int cod_stock);
	
	@Query(value="SELECT * FROM registro_venta WHERE cod_local=?1", nativeQuery=true)
	List<Registro_venta> getAllRegisterByID(int cod_stock);

}
