package com.inventario.service.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="unidad_medida")
public class Unidad_medida implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codigo")
	private int codigo;
	@Column(name="unidad_medida")
	private String unidad_medida;
	@Column(name="cantidad")
	private int cantidad;
	
	@OneToMany(mappedBy = "unidad_medida")
	private Set<Stock_producto> stock_product;
	
	public Unidad_medida() {
	}

	public Unidad_medida(String unidad_medida, int cantidad) {
		super();
		this.unidad_medida = unidad_medida;
		this.cantidad = cantidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
