package com.inventario.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.context.LocalRSocketServerPort;
import org.springframework.stereotype.Service;

import com.inventario.service.models.Local;
import com.inventario.service.models.Plato;
import com.inventario.service.models.Preparacion;
import com.inventario.service.repository.LocalRepository;
import com.inventario.service.repository.PlatoRepository;

@Service
public class PlatoServiceImpl implements PlatoService{

	@Autowired
	private PlatoRepository platoRepository;
	
	@Autowired
	private LocalRepository localRepository;
	
	/**
	 * {@link com.inventario.service.services.PlatoServiceImpl#register_plato(Plato)}
	 * 
	 * Método para registrar platos
	 * 
	 * @param Plato entity 
	 * 
	 * @return 200 si el registro es exitoso
	 * 
	 */
	
	@Override
	public String register_plato(Plato plato, String nombre) {
		int code = localRepository.getIdLocal(nombre);
		if(platoRepository.ifExistsPlato(plato.getNombre(),code)==false){
			platoRepository.save(plato);
			return "200";
		}else {
			return "308";
		}
		
	}
	
	/**
	 * {@link com.inventario.service.services.PlatoServiceImpl#getAllPlatos()}
	 * 
	 * Método para traer todos los platos de la base de datos
	 * 
	 * @return List<Plato>
	 * 
	 */

	@Override
	public List<Plato> getAllPlatos(String nombre) {
		int code = localRepository.getIdLocal(nombre);
		List<Plato> platos = platoRepository.findAllStockByid(code);
		return platos;
	}
	
	/**
	 * {@link com.inventario.service.services.PlatoServiceImpl#getPlato(int)}
	 * 
	 * Método para traer plato por el codigo del plato
	 * 
	 * @param codigo_plato
	 * 
	 * @return Plato entity
	 * 
	 */

	@Override
	public Plato getPlato(int codigo_plato) {
		if(platoRepository.ifExistsPlatoByid(codigo_plato)==true) {
			return platoRepository.findPlatoByNum(codigo_plato);
		}else{
			return null;
		}
	}
	
	/**
	 * {@link com.inventario.service.services.PlatoServiceImpl#deletPlato(int)}
	 * 
	 * Método para eliminar el plato por codigo
	 * 
	 * @param codigo
	 * 
	 * @return 200 si el registro es exitoso
	 * 
	 */

	@Override
	public String deletPlato(int codigo) {
		if(platoRepository.ifExistsPlatoByid(codigo)==true){
			platoRepository.deleteById(codigo);
			return  "200";
		}else {
			return "400";
		}
	}
	
	/**
	 * {@link com.inventario.service.services.PlatoServiceImpl#update(Plato, int)}
	 * 
	 * Método para actualizar datos de plato
	 * 
	 * @param Plato entity
	 * @param id del plato
	 * 
	 * @return 200 si se actualizo con exitoso
	 * 
	 */

	@Override
	public void update(Plato plato, int id) {
		platoRepository.findById(id).ifPresent((x)->{
			plato.setCodigo(id);
			platoRepository.save(plato);
		});
	}
	
	/**
	 * {@link com.inventario.service.services.PlatoServiceImpl#getPlatoId(String)}
	 * 
	 * Método para retornar el id del plato por nombre
	 * 
	 * @param nombre del plato
	 * 
	 * @return codigo del plato
	 * 
	 */

	@Override
	public int getPlatoId(String nombre) {
		if(platoRepository.ifExistsPlatoByName(nombre)==true){
			return platoRepository.PlatoByid(nombre);
		}else {
			return 400;
		}
	}
	
	/**
	 * {@link com.inventario.service.services.PlatoServiceImpl#getPlatoByname(String)}
	 * 
	 * Método para retornar un plato por el nombre
	 * 
	 * @param nombre del plato
	 * 
	 * @return Plato entity
	 * 
	 */

	@Override
	public Plato getPlatoByname(String nombre) {
		if(platoRepository.getPlatoByName(nombre)!=null) {
			return platoRepository.getPlatoByName(nombre);
		}else {
			return null;
		}
	}
	
	public void deletePlatoEntity(Plato plato) {
		platoRepository.delete(plato);
	}
	
	
	
	
}
