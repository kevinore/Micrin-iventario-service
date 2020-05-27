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

import com.inventario.service.models.Producto;
import com.inventario.service.services.ProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@RequestMapping(value = "/invservice/producto/registro", method=RequestMethod.POST)
	public void registro(HttpServletResponse response,@Valid @RequestBody Producto producto) throws IOException{
		String validation = productoService.register_producto(producto);
		System.out.println(validation);
		if(validation == "200"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Producto was register");
		}else if(validation == "406"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("The producto doesn't exist");
		}
	}
	
	@RequestMapping(value = "/invservice/producto/all",method = RequestMethod.GET)
	public List<Producto> getAll(){
		return productoService.getAllProductos();
	}
}
