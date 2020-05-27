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
@Table(name="receta")
public class Receta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="codigo_spro")
	private int codigo_spro;
	@Column(name="codigo_plato")
	private int codigo_plato;
	@Column(name="cantidadxplato")
	private int cantidadxplato;
	
	@ManyToOne
	@JoinColumn(name = "codigo_spro", insertable = false, updatable = false)
	private Stock_producto stock_producto;
	
	@ManyToOne
	@JoinColumn(name = "codigo_plato", insertable = false, updatable = false)
	private Plato plato;
	
	
	public Receta() {

	}

	public Receta(int codigo_spro, int codigo_plato, int cantidadxplato) {
		super();
		this.codigo_spro = codigo_spro;
		this.codigo_plato = codigo_plato;
		this.cantidadxplato = cantidadxplato;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodigo_spro() {
		return codigo_spro;
	}
	public void setCodigo_spro(int codigo_spro) {
		this.codigo_spro = codigo_spro;
	}
	public int getCodigo_plato() {
		return codigo_plato;
	}
	public void setCodigo_plato(int codigo_plato) {
		this.codigo_plato = codigo_plato;
	}
	public int getCantidadxplato() {
		return cantidadxplato;
	}
	public void setCantidadxplato(int cantidadxplato) {
		this.cantidadxplato = cantidadxplato;
	}

}
