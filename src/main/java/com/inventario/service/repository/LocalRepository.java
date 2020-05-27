package com.inventario.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.inventario.service.models.Local;
import com.inventario.service.models.Stock_producto;



public interface LocalRepository extends CrudRepository<Local, Integer> {
	
	@Query(value="SELECT l.codigo FROM local l WHERE LOWER(l.nombre)=LOWER(?1)", nativeQuery = true)
	int getIdLocal(String nombre);
}
