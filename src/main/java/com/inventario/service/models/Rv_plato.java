package com.inventario.service.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rv_plato")
public class Rv_plato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="cod_rv")
	private int cod_rv;
	@Column(name="cod_plato")
	private int cod_plato;
	@Column(name="cantidad")
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "cod_rv", insertable = false, updatable = false)
	private Registro_venta registro_venta;
	
	@ManyToOne
	@JoinColumn(name = "cod_plato", insertable = false, updatable = false)
	private Plato plato;
	
	public Rv_plato(int cod_rv, int cod_plato, int cantidad) {
		super();
		this.cod_rv = cod_rv;
		this.cod_plato = cod_plato;
		this.cantidad = cantidad;
	}

	public Rv_plato() {
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCod_rv() {
		return cod_rv;
	}
	public void setCod_rv(int cod_rv) {
		this.cod_rv = cod_rv;
	}
	public int getCod_plato() {
		return cod_plato;
	}
	public void setCod_plato(int cod_plato) {
		this.cod_plato = cod_plato;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
