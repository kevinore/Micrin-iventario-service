package com.inventario.service.services;

import java.util.List;

import com.inventario.service.models.Preparacion;

public interface PreparacionService {
	
	/**
	 * Definición de los métodos que luego serán implementados en la subclase que herede de esta
	 */
	String register_preparacion(Preparacion preparacion);
	List<Preparacion> getAllPreparacion();
	String deletePreparacion(int id);
	
}
