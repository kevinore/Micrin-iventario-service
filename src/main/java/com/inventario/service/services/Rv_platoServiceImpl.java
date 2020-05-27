package com.inventario.service.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.service.models.Rv_plato;
import com.inventario.service.models.Stock_producto;
import com.inventario.service.repository.RecetaRepository;
import com.inventario.service.repository.Rv_platoRepository;
import com.inventario.service.repository.Stock_productoRepository;

@Service
public class Rv_platoServiceImpl implements Rv_platoService{

	@Autowired
	private Rv_platoRepository rv_platoRepository;
	
	@Autowired
	private RecetaRepository recetaRepository;
	
	@Autowired
	private Stock_productoRepository stock_productoRepository;
	
	/**
	 * {@link com.inventario.service.services.Rv_platoServiceImpl#register_rv_plato(Rv_plato)}
	 * 
	 * Método para registrar el registro de platos (tabla intermedia)
	 * 
	 * @param Rv_plato entity
	 * 
	 * @return 200 si el registro es exitoso
	 * 
	 */
	
	@Override
	public String register_rv_plato(Rv_plato rv_plato) {
		rv_platoRepository.save(rv_plato);
		List<Integer> receta =recetaRepository.selectDataFromReceta(rv_plato.getCod_plato());
		
		String restric1 = "";
		String restric2 = "";
		String restric3 = "";
		
		for(int i=0; i<receta.size();i++) {
			if(stock_productoRepository.getCantidad_actual(receta.get(i))==0){
				restric1="301";
			}else if(stock_productoRepository.getCantidad_actual(receta.get(i))<stock_productoRepository.getExistenciaMinima(receta.get(i)) && stock_productoRepository.getCantidad_actual(receta.get(i))<=recetaRepository.selectCantida(receta.get(i), rv_plato.getCod_plato())*rv_plato.getCantidad()) {
				restric2="302";
			}else if(stock_productoRepository.getCantidad_actual(receta.get(i))<stock_productoRepository.getExistenciaMinima(receta.get(i)) && stock_productoRepository.getCantidad_actual(receta.get(i))>=recetaRepository.selectCantida(receta.get(i), rv_plato.getCod_plato())*rv_plato.getCantidad()) {
				int cantidadResatar = recetaRepository.selectCantida(receta.get(i), rv_plato.getCod_plato())*rv_plato.getCantidad();
				stock_productoRepository.updateCantidad_total(stock_productoRepository.getCantidad_actual(receta.get(i))-cantidadResatar, receta.get(i));
				restric3="303";
			}else if(stock_productoRepository.getCantidad_actual(receta.get(i))<stock_productoRepository.getExistenciaMinima(receta.get(i)) && stock_productoRepository.getCantidad_actual(receta.get(i))==recetaRepository.selectCantida(receta.get(i), rv_plato.getCod_plato())*rv_plato.getCantidad()) {
				int cantidadResatar = recetaRepository.selectCantida(receta.get(i), rv_plato.getCod_plato())*rv_plato.getCantidad();
				stock_productoRepository.updateCantidad_total(stock_productoRepository.getCantidad_actual(receta.get(i))-cantidadResatar, receta.get(i));
				restric3="303";
			}else {
				int cantidadResatar = recetaRepository.selectCantida(receta.get(i), rv_plato.getCod_plato())*rv_plato.getCantidad();
				stock_productoRepository.updateCantidad_total(stock_productoRepository.getCantidad_actual(receta.get(i))-cantidadResatar, receta.get(i));
			}
		}
		
		if(restric1 == "301") {
			return "301";
		}else if(restric2 == "302") {
			return "302";
		}else if(restric3 == "303") {
			return "303";
		}else {
			return "200";
		}
	}
	
	/**
	 * {@link com.inventario.service.services.Rv_platoServiceImpl#getAllrv_plato()}
	 * 
	 * Método para buscar todos los registros de la tabla Rv_plato en la base de datos
	 *
	 * @return List<Rv_plato>
	 * 
	 */

	@Override
	public List<Rv_plato> getAllrv_plato() {
		List<Rv_plato> rv_platos = (List<Rv_plato>) rv_platoRepository.findAll();
		return rv_platos;
	}

}
