package com.antartyca.torneos_Adrian_Mikel.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="Federaciones")
public class FederacionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_federacion;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String cif;
	
	@NotEmpty
	private String direccion;
	
	@NotEmpty
	@Pattern(regexp="^[0-9]*$")
	private String telefono;
	
	@OneToMany(mappedBy = "federacion", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("federacion")
	private List<DepartamentoModel> departamentos;
	
	@OneToMany(mappedBy = "federacion", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("federacion")
	private  List<TorneoModel> torneos;
	
//	GETTERS AND SETTERS
	public Integer getId_federacion() {
		return id_federacion;
	}

	public void setId_federacion(Integer id_federacion) {
		this.id_federacion = id_federacion;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<DepartamentoModel> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<DepartamentoModel> departamentos) {
		this.departamentos = departamentos;
	}

	public List<TorneoModel> getTorneos() {
		return torneos;
	}

	public void setTorneos(List<TorneoModel> torneos) {
		this.torneos = torneos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	
}
