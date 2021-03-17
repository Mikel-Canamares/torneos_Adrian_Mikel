package com.antartyca.torneos_Adrian_Mikel.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Departamentos")
public class DepartamentoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_departamento;
	
	private String nombre;
	
	private String descripcion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_federacion")
	@JsonIgnoreProperties("departamentos")
	private FederacionModel federacion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cod_ciudad")
	@JsonIgnoreProperties("departamentos")
	private CiudadModel ciudad;
	
	@OneToMany(mappedBy = "departamento")
	@JsonIgnoreProperties("departamento")
	private List<EmpleadoModel> empleados;

	
//	GETTERS AND SETTERS
	public Integer getCod_departamento() {
		return cod_departamento;
	}

	public void setCod_departamento(Integer cod_departamento) {
		this.cod_departamento = cod_departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public FederacionModel getFederacion() {
		return federacion;
	}

	public void setFederacion(FederacionModel federacion) {
		this.federacion = federacion;
	}

	public CiudadModel getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadModel ciudad) {
		this.ciudad = ciudad;
	}

	public List<EmpleadoModel> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EmpleadoModel> empleados) {
		this.empleados = empleados;
	}
	
	
	
}
