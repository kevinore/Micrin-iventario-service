package com.inventario.service.services;

import java.util.List;

import com.inventario.service.models.Producto;

public interface ProductoService {
	
	/**
	 * Definición de los métodos que luego serán implementados en la subclase que herede de esta
	 */
	String register_producto(Producto producto);
	List<Producto> getAllProductos();
}
