package com.inventario.service.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="stock_producto")
public class Stock_producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codigo")
	private int codigo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="cantidad_total")
	private int cantidad_total;
	@Column(name="existencia_maxima")
	private int existencia_maxima;
	@Column(name="existencia_minima")
	private int existencia_minima;
	@Column(name="preparacion")
	private boolean preparacion;
	@Column(name="cod_local")
	private int cod_local;
	@Column(name="cod_umedida")
	private int cod_umedida;
	
	@OneToMany(mappedBy = "stock_producto",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private Set<Preparacion> preparaciones;
	
	@OneToMany(mappedBy = "stock_producto",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private Set<Producto> productos;
	
	@ManyToOne
	@JoinColumn(name = "cod_umedida", insertable = false, updatable = false)
	private Unidad_medida unidad_medida;
	
	@OneToMany(mappedBy = "stock_producto",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private Set<Receta> receta;
	
	
	public Stock_producto() {
	}

	public Stock_producto(String nombre, int cantidad_total, int existencia_maxima, int existencia_minima,
			boolean preparacion, int cod_local, int cod_umedida) {
		super();
		this.nombre = nombre;
		this.cantidad_total = cantidad_total;
		this.existencia_maxima = existencia_maxima;
		this.existencia_minima = existencia_minima;
		this.preparacion = preparacion;
		this.cod_local = cod_local;
		this.cod_umedida = cod_umedida;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad_total() {
		return cantidad_total;
	}

	public void setCantidad_total(int cantidad_total) {
		this.cantidad_total = cantidad_total;
	}

	public int getExistencia_maxima() {
		return existencia_maxima;
	}

	public void setExistencia_maxima(int existencia_maxima) {
		this.existencia_maxima = existencia_maxima;
	}

	public int getExistencia_minima() {
		return existencia_minima;
	}

	public void setExistencia_minima(int existencia_minima) {
		this.existencia_minima = existencia_minima;
	}

	public boolean isPreparacion() {
		return preparacion;
	}

	public void setPreparacion(boolean preparacion) {
		this.preparacion = preparacion;
	}

	public int getCod_local() {
		return cod_local;
	}

	public void setCod_local(int cod_local) {
		this.cod_local = cod_local;
	}

	public int getCod_umedida() {
		return cod_umedida;
	}

	public void setCod_umedida(int cod_umedida) {
		this.cod_umedida = cod_umedida;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Set<Preparacion> getPreparaciones() {
		return preparaciones;
	}

	public void setPreparaciones(Set<Preparacion> preparaciones) {
		this.preparaciones = preparaciones;
	}

	public Set<Receta> getReceta() {
		return receta;
	}

	public void setReceta(Set<Receta> receta) {
		this.receta = receta;
	}
}
