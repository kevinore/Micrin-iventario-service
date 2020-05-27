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

import com.inventario.service.models.Registro_venta;
import com.inventario.service.services.Registro_ventaService;

import io.jsonwebtoken.Jwts;

@RestController
public class Registro_ventaController {
	
	@Autowired
	private Registro_ventaService registro_ventaService;
	
	@RequestMapping(value="/invservice/registro_venta/registro")
	public void registro(HttpServletResponse response,@Valid @RequestBody Registro_venta registro_venta) throws IOException{
		Registro_venta validation = registro_ventaService.register_registro_venta(registro_venta);
		if(validation != null){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println(registro_venta.getCodigo());
		}
	}
	
	@RequestMapping(value = "/invservice/registro_venta/all",method = RequestMethod.GET)
	public List<Registro_venta> getAll(HttpServletRequest request){
		String token = request.getHeader("Authorization");
		if (token != null) {
			String nombre = Jwts.parser()
					.setSigningKey("M@cr@n")
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
			return registro_ventaService.getAllRegistros_ventas(nombre);
		}
		return null;
	}
	
	@RequestMapping(value="/invservice/registro_venta/getone", method=RequestMethod.GET)
	public Registro_venta getone(HttpServletResponse response,@RequestParam("codigo") int codigo) throws IOException{
		Registro_venta registro = registro_ventaService.getResgistro_venta(codigo);
		if(registro != null){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			return registro; 
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Stock doesn't exists");
			return null;
		}
	}
	
}
