package com.antartyca.torneos_Adrian_Mikel.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Empleados")
public class EmpleadoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_empleado;
	
	private String nombre;
	
	private String direccion;
	
	private Integer telefono;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cod_departamento")
	@JsonIgnoreProperties("empleados")
	private DepartamentoModel departamento;
	
//	GETTERS AND SETTERS
	public Integer getCod_empleado() {
		return cod_empleado;
	}

	public void setCod_empleado(Integer cod_empleado) {
		this.cod_empleado = cod_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public DepartamentoModel getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoModel departamento) {
		this.departamento = departamento;
	}
	
	
}
