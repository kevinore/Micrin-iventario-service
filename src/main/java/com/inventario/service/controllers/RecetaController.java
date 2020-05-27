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

import com.inventario.service.models.Receta;
import com.inventario.service.services.RecetaService;

@RestController
public class RecetaController {
	
	@Autowired
	private RecetaService recetaService;
	
	@RequestMapping(value="/invservice/receta/registro", method=RequestMethod.POST)
	public void registro(HttpServletResponse response,@Valid @RequestBody Receta receta) throws IOException{
		String validation = recetaService.register_receta(receta);
		if(validation == "200"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Preparacion was register");
		}
	}
	
	@RequestMapping(value = "/invservice/receta/all",method = RequestMethod.GET)
	public List<Receta> getAll(){
		return recetaService.getAllRecetas();
	}
	
	@RequestMapping(value="/invservice/receta/delete", method=RequestMethod.DELETE)
	public void borrar(HttpServletResponse response,@RequestParam("codigo") int id) throws IOException{
		String validation = recetaService.deletRecta(id);
		if(validation == "200"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Receta was delete");
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(404);
			response.getWriter().println("Receta doesn't exists");
		}
	}
}
