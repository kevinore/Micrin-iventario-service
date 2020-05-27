package com.inventario.service.services;

import java.util.List;
import java.util.Optional;

import com.inventario.service.models.Plato;

public interface PlatoService {
	
	String register_plato(Plato plato, String nombre);
	List<Plato> getAllPlatos(String nombre);
	Plato getPlato(int codigo_plato);
	String deletPlato(int codigo);
	void update(Plato plato, int id);
	int getPlatoId(String nombre);
	Plato getPlatoByname(String nombre);
	void deletePlatoEntity(Plato plato);
}
