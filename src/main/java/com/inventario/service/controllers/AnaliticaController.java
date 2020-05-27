package com.inventario.service.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;



@RestController
public class AnaliticaController {
	
	@Autowired
    private RestTemplate restTemplate;
	Gson gson = new Gson();
	@RequestMapping(value="/invservice/analitica", method=RequestMethod.GET)
	public List getAnalitica(HttpServletResponse response) throws IOException{
		String an = restTemplate.getForObject("https://analiticaapp.herokuapp.com/analitica", String.class);
		response.setHeader("Custom-Header", "foo");
		response.setStatus(200);
		JSONArray array = new JSONArray(an);
		return array.toList();
	}
}
