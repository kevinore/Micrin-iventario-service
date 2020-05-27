package com.inventario.service.services;

import java.util.List;

import com.inventario.service.models.Receta;

public interface RecetaService {
	/**
	 * Definición de los métodos que luego serán implementados en la subclase que herede de esta
	 */
	String register_receta(Receta receta);
	List<Receta> getAllRecetas();
	String deletRecta(int codigo_receta);
}
