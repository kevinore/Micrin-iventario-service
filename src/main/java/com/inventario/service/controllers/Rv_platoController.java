package com.inventario.service.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.service.models.Rv_plato;
import com.inventario.service.services.Rv_platoService;

@RestController
public class Rv_platoController {
	
	@Autowired
	private Rv_platoService rv_pltosService;
	
	@RequestMapping(value="/invservice/rv_plato/registro", method=RequestMethod.POST)
	public void registro(HttpServletResponse response,@Valid @RequestBody Rv_plato rv_plato) throws IOException{
		String validation = rv_pltosService.register_rv_plato(rv_plato);
		if(validation == "200"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Rv plato was register");
		}else if(validation == "301"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(301);
			response.getWriter().println("Hay ingredientes con cantidad 0");
		}else if(validation == "302"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(302);
			response.getWriter().println("No hay el sufuciende ingrediente para este plato");
		}else if(validation == "303"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(303);
			response.getWriter().println("Alerta!! cantidad minima excedida");
		}
	}
	
	@RequestMapping(value = "/invservice/rv_plato/all",method = RequestMethod.GET)
	public List<Rv_plato> getAll(){
		return rv_pltosService.getAllrv_plato();
	}

}
