package com.inventario.service.services;

import java.util.List;

import com.inventario.service.models.Rv_plato;

public interface Rv_platoService {
	
	/**
	 * Definición de los métodos que luego serán implementados en la subclase que herede de esta
	 */
	
	String register_rv_plato(Rv_plato rv_plato);
	List<Rv_plato> getAllrv_plato();
}
