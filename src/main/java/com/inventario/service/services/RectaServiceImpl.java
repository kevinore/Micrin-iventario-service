package com.inventario.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.service.models.Receta;
import com.inventario.service.models.Registro_venta;
import com.inventario.service.repository.RecetaRepository;

@Service
public class RectaServiceImpl implements RecetaService{

	@Autowired
	private RecetaRepository recetaRepository;
	
	/**
	 * {@link com.inventario.service.services.RectaServiceImpl#register_receta(Receta)}
	 * 
	 * Método para registrar las recetas
	 * 
	 * @param Receta entity 
	 * 
	 * @return 200 si se eliminó con éxito
	 * 
	 */
	
	@Override
	public String register_receta(Receta receta) {
		recetaRepository.save(receta);
		return "200";
	}
	
	/**
	 * {@link com.inventario.service.services.RectaServiceImpl#getAllRecetas()}
	 * 
	 * Método para traer todos las recetas de la base de datos
	 * 
	 * @return List<Receta>
	 * 
	 */

	@Override
	public List<Receta> getAllRecetas() {
		List<Receta> recetas = (List<Receta>) recetaRepository.findAll();
		return recetas;
	}
	
	/**
	 * {@link com.inventario.service.services.RectaServiceImpl#deletRecta(int)}
	 * 
	 * Método para traer todos las recetas de la base de datos
	 * 
	 * @param codigo_receta del la receta que se va a eliminar
	 * 
	 * @return 200 se elimino la receta con exito
	 * 
	 */

	@Override
	public String deletRecta(int codigo_receta) {
		
		if(recetaRepository.ifExistsReceta(codigo_receta)==true) {
			recetaRepository.deleteById(codigo_receta);
			return "200";
		}else {
			return "404";
		}
	}
	

	
	
	
}
