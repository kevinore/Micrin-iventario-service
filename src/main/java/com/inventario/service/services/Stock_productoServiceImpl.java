package com.inventario.service.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.service.models.Stock_producto;
import com.inventario.service.repository.LocalRepository;
import com.inventario.service.repository.Stock_productoRepository;

@Service
public class Stock_productoServiceImpl implements Stock_productoService{

	@Autowired
	private Stock_productoRepository stock_productoRepository;
	
	@Autowired
	private LocalRepository localRepository;
	
	/**
	 * {@link com.inventario.service.services.Stock_productoServiceImpl#register_stock(Stock_producto)}
	 * 
	 * Método encargado del registro de los stocks antes del registro se valida que el stock 
	 * no se halla registro anteriormente
	 * 
	 * @param stock_producto
	 * 
	 * @return 200 si se eliminó con éxito
	 */
	
	@Override
	public String register_stock(Stock_producto stock_producto) {
		if(stock_productoRepository.ifExistsStock(stock_producto.getNombre(), stock_producto.getCod_local())==false){
			stock_productoRepository.save(stock_producto);
			return "200";
		}else{
			return "400";
		}
	}
	
	/**
	 * {@link com.inventario.service.services.Stock_productoServiceImpl#getAllStock()}
	 * 
	 * Método que taer todo los registro de los stocks registrados
	 * 
	 * @return List<Stock_producto>
	 */
	
	@Override
	public List<Stock_producto> getAllStock(String nombre) {
		int code = localRepository.getIdLocal(nombre);
		System.out.println(code);
		List<Stock_producto> stock_producto = stock_productoRepository.getAllStockById(code);
		return stock_producto;
	}
	
	/**
	 * {@link com.inventario.service.services.Stock_productoServiceImpl#deletStock(int)}
	 * 
	 * Método que elimina los stocks por id 
	 * 
	 * @param codigo stock
	 * 
	 * @return 200 si se el stock se borro con exito
	 */

	@Override
	public String deletStock(int codigo) {
		if(stock_productoRepository.ifExistsStockById(codigo)==true){
			stock_productoRepository.deleteById(codigo);
			return "200";
		}else{
			return "400";
		}
	}
	
	/**
	 * {@link com.inventario.service.services.Stock_productoServiceImpl#update(Stock_producto, int)}
	 * 
	 * Método que hacer updates de los datos registrados en base de datos 
	 * 
	 * @param stock_producto entity
	 * @param id del stock
	 * 
	 */

	@Override
	public void update(Stock_producto stock_producto, int id) {
		stock_productoRepository.findById(id).ifPresent((x)->{
			stock_producto.setCodigo(id);
			stock_productoRepository.save(stock_producto);
		});
	}
	
	/**
	 * {@link com.inventario.service.services.Stock_productoServiceImpl#getId(Stock_producto)}
	 * 
	 * Método que retorna el id de un stock por el nombre del stock 
	 * 
	 * @param stock_producto entity
	 * 
	 * @return id stock producto
	 */

	@Override
	public int getId(Stock_producto stock_producto) {
		if(stock_productoRepository.ifExistsStockByName(stock_producto.getNombre())==true) {
			return stock_productoRepository.StockById(stock_producto.getNombre());
		}else {
			return 400;
		}
		
	}
	
	/**
	 * {@link com.inventario.service.services.Stock_productoServiceImpl#getStock(int)}
	 * 
	 * Método que busca y retorna un stock por su id
	 * 
	 * @param codigo
	 * 
	 * @return Stock_producto
	 */

	@Override
	public Stock_producto getStock(int codigo) {
		if(stock_productoRepository.ifExistsStockById(codigo)==true) {
		   return stock_productoRepository.getStock(codigo);
		}else {
			return null;
		}
		
	}
	
	/**
	 * {@link com.inventario.service.services.Stock_productoServiceImpl#getStockByname(String)}
	 * 
	 * Método que busca y retorna un stock por su nombre
	 * 
	 * @param name
	 * 
	 * @return Stock_producto
	 */

	@Override
	public Stock_producto getStockByname(String name) {
		if(stock_productoRepository.ifExistsStockByName(name)  == true) {
			return stock_productoRepository.StockByname(name);
		}else {
			return null;
		}
		
	}
	
	
	
}
