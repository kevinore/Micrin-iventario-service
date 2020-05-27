package com.inventario.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.service.models.Registro_venta;
import com.inventario.service.models.Rv_plato;
import com.inventario.service.repository.LocalRepository;
import com.inventario.service.repository.Registro_ventaRepository;

@Service
public class Registro_ventaServiceImpl implements Registro_ventaService{

	@Autowired
	private Registro_ventaRepository registroVentaRepository;
	
	@Autowired
	private LocalRepository localRepository;
	
	/**
	 * {@link com.inventario.service.services.Registro_ventaServiceImpl#register_registro_venta(Registro_venta)}
	 * 
	 * Método para registrar el registro de venta
	 * 
	 * @param Registro_venta entity 
	 * 
	 * @return 200 si se eliminó con éxito
	 * 
	 */
	
	@Override
	public Registro_venta register_registro_venta(Registro_venta registro_venta) {
		registroVentaRepository.save(registro_venta);
		return registro_venta;
	}
	
	/**
	 * {@link com.inventario.service.services.Registro_ventaServiceImpl#getAllRegistros_ventas()}
	 * 
	 * Método para traer todos los registros de ventas en la base de datos
	 * 
	 * @return List<Registro_venta>
	 * 
	 */

	@Override
	public List<Registro_venta> getAllRegistros_ventas(String nombre) {
		int code = localRepository.getIdLocal(nombre);
		List<Registro_venta> registro_venta = registroVentaRepository.getAllRegisterByID(code);
		return registro_venta;
	}
	
	/**
	 * {@link com.inventario.service.services.Registro_ventaServiceImpl#getResgistro_venta(int)}
	 * 
	 * Método para traer un registro de ventas por el id
	 * 
	 * @param id_registro_venta
	 * 
	 * @return Registro_venta
	 * 
	 */

	@Override
	public Registro_venta getResgistro_venta(int id_registro_venta) {
		if(registroVentaRepository.ifexistsBycodigo(id_registro_venta)==true) {
			return registroVentaRepository.getRegistro(id_registro_venta);
		}else {
			return null;
		}
	}
	
	
}
