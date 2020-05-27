package com.inventario.service.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.service.models.Unidad_medida;
import com.inventario.service.services.Unidad_medidaService;

@RestController
public class Unidad_medidaController {
	
	@Autowired
	private Unidad_medidaService unidad_medidaService;
	
	@RequestMapping(value="/invservice/unidadmedida/registro", method=RequestMethod.POST)
	public void registro(HttpServletResponse response,@Valid @RequestBody Unidad_medida unidad_medida) throws IOException{
		String validation = unidad_medidaService.register_unidad_medida(unidad_medida);
		if(validation == "200"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Unidad de medida was register");
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(304);
			response.getWriter().println("Unidad de medida already register");
		}
	}
	
	@RequestMapping(value = "/invservice/unidadmedida/all",method = RequestMethod.GET)
	public List<Unidad_medida> getAll(){ 
		return unidad_medidaService.getAllUnidad_medida();
	}
	
	@RequestMapping(value="/invservice/unidadmedida/getcode", method=RequestMethod.GET)
	public Unidad_medida getone(HttpServletResponse response,@RequestParam("nombre") String nombre, @RequestParam("cantidad") int cantidad) throws IOException{
		Unidad_medida code =unidad_medidaService.ifExistUnidad_medida(nombre, cantidad);
		if(code != null){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			return code;	
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(404);
			return null;
		}
	}
	
	@RequestMapping(value="/invservice/unidadmedida/getone", method=RequestMethod.GET)
	public Unidad_medida getone(HttpServletResponse response,@RequestParam("codigo") int codigo) throws IOException{
		Unidad_medida unidad_medida = unidad_medidaService.getunidad_medidabyid(codigo);
		if(unidad_medida != null){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			return unidad_medida;	
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Stock doesn't exists");
			return null;
		}
	}
	@RequestMapping(value="/invservice/unidadmedida/exists", method=RequestMethod.GET)
	public String ifExists(HttpServletResponse response,@RequestParam("unidad_medida") String unidad_medida,@RequestParam("cantidad") int cantidad ) throws IOException{
		boolean unidad = unidad_medidaService.getIfExistsUnidaMedida(unidad_medida, cantidad);
		if(unidad == true){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			return "Unidad de medida exists";	
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(404);
			return "Unidad de mediad doest'n exists";
		}
	}
}
