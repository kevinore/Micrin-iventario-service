package com.inventario.service.services;

import java.util.List;

import com.inventario.service.models.Stock_producto;

public interface Stock_productoService {
	
	/**
	 * Definición de los métodos que luego serán implementados en la subclase que herede de esta
	 */
	
	String register_stock(Stock_producto stock_producto);
	List<Stock_producto> getAllStock(String nombre);
	String deletStock(int codigo);
	void update(Stock_producto stock_producto, int id);
	int getId(Stock_producto stock_producto);
	Stock_producto getStock(int codigo);
	Stock_producto getStockByname(String name);
}
