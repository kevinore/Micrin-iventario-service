package com.inventario.service.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.service.models.Plato;
import com.inventario.service.services.PlatoService;

import io.jsonwebtoken.Jwts;

@RestController
public class PlatoController {
	
	@Autowired
	private PlatoService platoService;
	
	@RequestMapping(value="/invservice/plato/registro", method=RequestMethod.POST)
	public void registro(HttpServletResponse response,HttpServletRequest request,@Valid @RequestBody Plato plato) throws IOException{
		String validation = null;
		String token = request.getHeader("Authorization");
		if (token != null) {
			String nombre = Jwts.parser()
					.setSigningKey("M@cr@n")
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
			 validation = platoService.register_plato(plato, nombre);
			if(validation == "200"){
				response.setHeader("Custom-Header", "foo");
				response.setStatus(200);
				response.getWriter().println("Plato was register");
			}else {
				response.setHeader("Custom-Header", "foo");
				response.setStatus(400);
				response.getWriter().println("Plato already exists");
			}
		}
	}
	
	@RequestMapping(value = "/invservice/plato/all",method = RequestMethod.GET)
	public List<Plato> getAll(HttpServletRequest request){
		
		String token = request.getHeader("Authorization");
		if (token != null) {
			String nombre = Jwts.parser()
					.setSigningKey("M@cr@n")
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
			return platoService.getAllPlatos(nombre);
		}
		return null;
	}
	
	@RequestMapping(value="/invservice/plato/delet", method=RequestMethod.DELETE)
	public void borrar(HttpServletResponse response,@RequestParam("codigo") int codigo) throws IOException{
		String validation = platoService.deletPlato(codigo);
		if(validation == "200"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Plato was delete");
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Plato doesn't exists");
		}
	}
	
	@RequestMapping(value="/invservice/plato/update", method=RequestMethod.PUT)
	public void update(HttpServletResponse response,@Valid @RequestBody Plato plato) throws IOException{
		int id = platoService.getPlatoId(plato.getNombre());
		if(id==400) {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Plato doesn't exists");
		}else{
			platoService.update(plato, id);
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Plato was updated");
		}
	}
	
	@RequestMapping(value="/invservice/plato/getone/", method=RequestMethod.GET)
	public Plato getOne(HttpServletResponse response,@RequestParam("codigo") int codigo) throws IOException{
		Plato plato = platoService.getPlato(codigo);
		if(plato != null){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			return plato;
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Plato doesn't exists");
			return null;
		}
	}
	
	@RequestMapping(value="/invservice/plato/getPlato/", method=RequestMethod.GET)
	public Plato getPlato(HttpServletResponse response,@RequestParam("nombre") String nombre) throws IOException{
		Plato plato = platoService.getPlatoByname(nombre);
		if(plato != null){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			return plato;
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Plato doesn't exists");
			return null;
		}
	}
}
