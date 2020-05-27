package com.inventario.service.controllers;

import static java.util.Collections.emptyList;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.service.models.Stock_producto;
import com.inventario.service.services.Stock_productoService;

import io.jsonwebtoken.Jwts;

@RestController
public class Stock_productoController {
	
	@Autowired
	private Stock_productoService stock_productoService;
	
	@RequestMapping(value="/invservice/stock/registro", method=RequestMethod.POST)
	public void registro(HttpServletResponse response,@Valid @RequestBody Stock_producto stock_producto) throws IOException{
		String validation = stock_productoService.register_stock(stock_producto);
		if(validation == "200"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Stock was register");
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Stock already exists");
		}
	}
	
	@RequestMapping(value = "/invservice/stock/all",method = RequestMethod.GET)
	public List<Stock_producto> getAll(HttpServletRequest request){
		String token = request.getHeader("Authorization");
		if (token != null) {
			String nombre = Jwts.parser()
					.setSigningKey("M@cr@n")
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
			return stock_productoService.getAllStock(nombre);
		}
		return null;
		
	}
	
	@RequestMapping(value="/invservice/stock/delet", method=RequestMethod.DELETE)
	public void borrar(HttpServletResponse response,@RequestParam("codigo") int codigo) throws IOException{
		String validation = stock_productoService.deletStock(codigo);
		if(validation == "200"){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Stock was delete");
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Stock doesn't exists");
		}
	}
	
	@RequestMapping(value="/invservice/stock/update", method=RequestMethod.PUT)
	public void update(HttpServletResponse response,@Valid @RequestBody Stock_producto stock_producto) throws IOException{
	    int id =stock_productoService.getId(stock_producto);
	    System.out.println(id);
	    if (id==400) {
	    	response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Stock doesn't exists");
	    }else {
	    	stock_productoService.update(stock_producto, id);
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Stock was updated");
	    }
	}
	
	@RequestMapping(value="/invservice/stock/getone", method=RequestMethod.GET)
	public Stock_producto getone(HttpServletResponse response,@RequestParam("codigo") int codigo) throws IOException{
		Stock_producto stock =stock_productoService.getStock(codigo);
		if(stock != null){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			return stock;	
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Stock doesn't exists");
			return null;
		}
	}
	
	@RequestMapping(value="/invservice/stock/getname", method=RequestMethod.GET)
	public Stock_producto getone(HttpServletResponse response,@RequestParam("nombre") String nombre) throws IOException{
		Stock_producto stock =stock_productoService.getStockByname(nombre);
		if(stock != null){
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			return stock;	
		}else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Stock doesn't exists");
			return null;
		}
	}
	
}
