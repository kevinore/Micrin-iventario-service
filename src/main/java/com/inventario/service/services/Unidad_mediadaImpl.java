package com.inventario.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.service.models.Unidad_medida;
import com.inventario.service.repository.Unidad_medidaRepository;


@Service
public class Unidad_mediadaImpl implements Unidad_medidaService{

	@Autowired
	private Unidad_medidaRepository unidad_medidaRepository;
	
	/**
	 * {@link com.inventario.service.services.Unidad_mediadaImpl#register_unidad_medida(Unidad_medida)} 
	 * Método para regitrar unidades de medida
	 * 
	 * @param unidad_medida este parametro es requerido para el registro de la unidad de medida
	 * 
	 * Adicional, para validar si la unida de medida ya existe se toman de la entidad unida de medida y cantida
	 * 
	 * @param unidad_medida.getUnidad_medida() 
	 * @param unidad_medida.getCantidad()
	 * 
	 */
	
	@Override
	public String register_unidad_medida(Unidad_medida unidad_medida) {
		if(unidad_medidaRepository.ifExistsStockByNameandCod(unidad_medida.getUnidad_medida(), unidad_medida.getCantidad())==true) {
			return "400";
		}else {
			unidad_medidaRepository.save(unidad_medida);
			return "200";
		}
	}
	
	/**
	 * {@link com.inventario.service.services.Unidad_mediadaImpl#getAllUnidad_medida()} 
	 * 
	 * Método para listar todas las unidades de medida registradas en la base de datos
	 * 
	 * @return List<Unidad_medida>
	 * 
	 */
	
	@Override
	public List<Unidad_medida> getAllUnidad_medida() {
		List<Unidad_medida> unidad_medida = (List<Unidad_medida>) unidad_medidaRepository.findAll();
		return unidad_medida;
	}
	
	/**
	 * {@link com.inventario.service.services.Unidad_mediadaImpl#ifExistUnidad_medida(String, int)} 
	 * 
	 * Método para validar si existe la unidad de medida basado en el nombre de la unidad de medida y la cantidad
	 * en caso de existir se retornara la unida de medida de lo contrario retornara un null
	 * 
	 * @param nombre unidad de medida
	 * @param cantidad unidad de medida
	 * 
	 * @return Unidad_medida
	 * 
	 */
	

	@Override
	public Unidad_medida ifExistUnidad_medida(String nombre, int cantidad) {
		if(unidad_medidaRepository.ifExistsStockByNameandCod(nombre, cantidad)==true) {
			return unidad_medidaRepository.getIdByNameCod(nombre, cantidad);
		}else {
			return null;
		}
	}
	
	/**
	 * {@link com.inventario.service.services.Unidad_mediadaImpl#getunidad_medidabyid(int)} 
	 * 
	 * Método para buscar una unidad de medida basado en el id
	 * 
	 *@param codigo del la unidad de medida
	 *
	 *@return Unidad_medida
	 */

	@Override
	public Unidad_medida getunidad_medidabyid(int codigo) {
		Unidad_medida unidad_medida = unidad_medidaRepository.getById(codigo);
		if(unidad_medida != null){
			return unidad_medida;
		}else {
			return null;
		}
	}

	@Override
	public boolean getIfExistsUnidaMedida(String unidad_medida, int cantidad) {
		if(unidad_medidaRepository.ifExistsStockByName(unidad_medida)==true && unidad_medidaRepository.ifExistsStockByCod(cantidad)) {
			return true;
		}else {
			return false;
		}
	}

}
