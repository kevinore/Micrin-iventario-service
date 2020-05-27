package com.inventario.service.services;
	
import java.util.List;

import com.inventario.service.models.Unidad_medida;

public interface Unidad_medidaService {
	
	/**
	 * Definición de los métodos que luego serán implementados en la subclase que herede de esta
	 */
	
	String register_unidad_medida(Unidad_medida unidad_medida);
	List<Unidad_medida> getAllUnidad_medida();
	Unidad_medida ifExistUnidad_medida(String nombre, int cantidad);
	Unidad_medida getunidad_medidabyid(int codigo);
	boolean getIfExistsUnidaMedida(String unidad_medida, int cantidad);
}
