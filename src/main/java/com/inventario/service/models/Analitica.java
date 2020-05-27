package com.inventario.service.models;



import com.fasterxml.jackson.annotation.JsonProperty;

public class Analitica {
	
	@JsonProperty
	String nombre_plato;
	@JsonProperty
	int unidades;
	@JsonProperty
	int cod_fecha;
	@JsonProperty
	String fecha;
	
	public Analitica() {
		
	}
	
	public Analitica(String nombre_plato, int unidades, int cod_fecha, String fecha) {
		super();
		this.nombre_plato = nombre_plato;
		this.unidades = unidades;
		this.cod_fecha = cod_fecha;
		this.fecha = fecha;
	}
	
	public String getNombre_plato() {
		return nombre_plato;
	}
	public void setNombre_plato(String nombre_plato) {
		this.nombre_plato = nombre_plato;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public int getCod_fecha() {
		return cod_fecha;
	}
	public void setCod_fecha(int cod_fecha) {
		this.cod_fecha = cod_fecha;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}	
}
