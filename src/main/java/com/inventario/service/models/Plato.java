package com.inventario.service.models;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="plato")
public class Plato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codigo")
	private int codigo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="costo")
	private int costo;
	@Column(name="cod_local")
	private int cod_local;
	
	@OneToMany(mappedBy = "plato",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private Set<Receta> receta;
	
	@OneToMany(mappedBy = "plato",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private Set<Rv_plato> rv_plato;
	
	@ManyToOne
	@JoinColumn(name="cod_local", insertable = false, updatable = false)
	private Local local;
	
	
	public Plato() {
	}
	
	public Plato(String nombre, int costo, int cod_local) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.cod_local = cod_local;
	}
	
	public Plato(int id,String nombre, int costo, int cod_local) {
		super();
		this.codigo=id;
		this.nombre = nombre;
		this.costo = costo;
		this.cod_local = cod_local;
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
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public int getCod_local() {
		return cod_local;
	}
	public void setCod_local(int cod_local) {
		this.cod_local = cod_local;
	}

	public Set<Rv_plato> getRv_plato() {
		return rv_plato;
	}

	public void setRv_plato(Set<Rv_plato> rv_plato) {
		this.rv_plato = rv_plato;
	}

	public Set<Receta> getReceta() {
		return receta;
	}

	public void setReceta(Set<Receta> receta) {
		this.receta = receta;
	}
	
	
}
