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

import com.inventario.service.models.Preparacion;
import com.inventario.service.services.PreparacionService;

@RestController
public class PreparacionController {

	@Autowired
	private PreparacionService preparacionService;
	
	@RequestMapping(value="/invservice/preparacion/registro", method=RequestMethod.POST)
	public void registro(HttpServletResponse response,@Valid @RequestBody Preparacion preparacion) throws IOException{
		String validation = preparacionService.register_preparacion(preparacion);
		if(validation == "200"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Preparacion was register");
		}
	}
	
	@RequestMapping(value = "/invservice/preparacion/all",method = RequestMethod.GET)
	public List<Preparacion> getAll(){
		return preparacionService.getAllPreparacion();
	}
	
	@RequestMapping(value="/invservice/preparacion/delet", method=RequestMethod.DELETE)
	public void borrar(HttpServletResponse response,@RequestParam("codigo") int id) throws IOException{
		String validation = preparacionService.deletePreparacion(id);
		if(validation == "200"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("DeletePreparacion was delete");
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(404);
			response.getWriter().println("DeletePreparacion doesn't exists");
		}
	}
}
