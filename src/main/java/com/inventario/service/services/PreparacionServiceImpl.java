package com.inventario.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.service.models.Preparacion;
import com.inventario.service.models.Producto;
import com.inventario.service.repository.PreparcionRepository;

@Service
public class PreparacionServiceImpl implements PreparacionService{

	@Autowired
	private PreparcionRepository preparacionRepository;
	
	/**
	 * {@link com.inventario.service.services.PreparacionServiceImpl#register_preparacion(Preparacion)}
	 * 
	 * Método para registrar preparaciones
	 * 
	 * @param Preparacion entity 
	 * 
	 * @return 200 si el registro es exitoso
	 * 
	 */
	
	@Override
	public String register_preparacion(Preparacion preparacion) {
		preparacionRepository.save(preparacion);
		return "200";
	}
	
	/**
	 * {@link com.inventario.service.services.PreparacionServiceImpl#getAllPreparacion()}
	 * 
	 * Método para listar todas las preparaciones
	 * 
	 * @return List<Preparacion>
	 * 
	 */

	@Override
	public List<Preparacion> getAllPreparacion() {
		List<Preparacion> preparacionlist = (List<Preparacion>) preparacionRepository.findAll();
		return preparacionlist;
	}
	
	/**
	 * {@link com.inventario.service.services.PreparacionServiceImpl#deletePreparacion(int)}
	 * 
	 * Método para eliminar preparaciones
	 * 
	 * @return 200 si se eliminó con éxito
	 * 
	 */

	@Override
	public String deletePreparacion(int id) {
		if(preparacionRepository.ifExistsPreparacion(id)==true) {
			preparacionRepository.deleteById(id);
			return "200";
		}else {
			return "400";
		}
	}

}
