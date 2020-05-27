package com.inventario.service.models;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="producto")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codigo")
	private int codigo;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="precioxunidad")
	private int precioxunidad;
	@Column(name="fecha_vencimiento")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_vencimiento;
	@Column(name="fecha_adquisicion")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_adquisicion;
	@Column(name="cod_stock")
	private int cod_stock;
	
	@ManyToOne
	@JoinColumn(name = "cod_stock", insertable = false, updatable = false)
	private Stock_producto stock_producto;
	
	public Producto() {
	}

	public Producto(int cantidad, int precioxunidad, Date fecha_vencimiento, Date fecha_adquisicion, int cod_stock,
			Stock_producto stock_producto) {
		super();
		this.cantidad = cantidad;
		this.precioxunidad = precioxunidad;
		this.fecha_vencimiento = fecha_vencimiento;
		this.fecha_adquisicion = fecha_adquisicion;
		this.cod_stock = cod_stock;
		this.stock_producto = stock_producto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioxunidad() {
		return precioxunidad;
	}

	public void setPrecioxunidad(int precioxunidad) {
		this.precioxunidad = precioxunidad;
	}

	public Date getFecha_vencimiento() throws ParseException {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public Date getFecha_adquisicion() throws ParseException {
		return fecha_adquisicion;
	}

	public void setFecha_adquisicion(Date fecha_adquisicion) {
		this.fecha_adquisicion = fecha_adquisicion;
	}

	public int getCod_stock() {
		return cod_stock;
	}

	public void setCod_stock(int cod_stock) {
		this.cod_stock = cod_stock;
	}
}
