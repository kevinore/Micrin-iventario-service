package com.inventario.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.service.models.Producto;
import com.inventario.service.models.Registro_venta;
import com.inventario.service.repository.ProductoRepository;
import com.inventario.service.repository.Stock_productoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private Stock_productoRepository stock_productoRepository;
	
	/**
	 * {@link com.inventario.service.services.ProductoServiceImpl#register_producto(Producto)}
	 * 
	 * Método para registrar productos
	 * 
	 * @param Producto entity 
	 * 
	 * @return 200 si se eliminó con éxito
	 * 
	 */
	
	@Override
	public String register_producto(Producto producto) {
		if(stock_productoRepository.findBycod_stock(producto.getCod_stock())==true) {
			productoRepository.save(producto);
			int cantidad_actual =stock_productoRepository.getCantidad_actual(producto.getCod_stock()) + producto.getCantidad();
			stock_productoRepository.updateCantidad_total(cantidad_actual, producto.getCod_stock());
			return "200";
		}else{
			return "406";
		}
	}
	
	/**
	 * {@link com.inventario.service.services.ProductoServiceImpl#getAllProductos()}
	 * 
	 * Método para listar todos los registrar productos
	 * 
	 * @return List<Producto>
	 * 
	 */

	@Override
	public List<Producto> getAllProductos() {
		List<Producto> prodcutosList = (List<Producto>) productoRepository.findAll();
		return prodcutosList;
	}
	
}
