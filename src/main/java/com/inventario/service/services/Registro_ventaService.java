package com.inventario.service.services;

import java.util.List;

import com.inventario.service.models.Registro_venta;

public interface Registro_ventaService {
	
	/**
	 * Definición de los métodos que luego serán implementados en la subclase que herede de esta
	 */
	
	Registro_venta register_registro_venta(Registro_venta registro_venta);
	List<Registro_venta> getAllRegistros_ventas(String nombre);
	Registro_venta getResgistro_venta(int id_registro_venta);
}
