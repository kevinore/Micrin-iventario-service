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
@Table(name="preparacion")
public class Preparacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="codigo_ingrediente")
	private int codigo_ingrediente;
	@Column(name="codigo_preparacion")
	private int codigo_preparacion;
	@Column(name="cantidadxpreparacion")
	private int cantidadxpreparacion;
	
	@ManyToOne
	@JoinColumn(name = "codigo_preparacion", insertable = false, updatable = false)
	private Stock_producto stock_producto;

	public Preparacion() {

	}

	public Preparacion(int codigo_ingrediente, int codigo_preparacion, int cantidadxpreparacion) {
		super();
		this.codigo_ingrediente = codigo_ingrediente;
		this.codigo_preparacion = codigo_preparacion;
		this.cantidadxpreparacion = cantidadxpreparacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo_ingrediente() {
		return codigo_ingrediente;
	}

	public void setCodigo_ingrediente(int codigo_ingrediente) {
		this.codigo_ingrediente = codigo_ingrediente;
	}

	public int getCodigo_preparacion() {
		return codigo_preparacion;
	}

	public void setCodigo_preparacion(int codigo_preparacion) {
		this.codigo_preparacion = codigo_preparacion;
	}

	public int getCantidadxpreparacion() {
		return cantidadxpreparacion;
	}

	public void setCantidadxpreparacion(int cantidadxpreparacion) {
		this.cantidadxpreparacion = cantidadxpreparacion;
	}
	
}
