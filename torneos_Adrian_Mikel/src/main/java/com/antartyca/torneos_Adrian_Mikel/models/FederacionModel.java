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
@Table(name="Federaciones")
public class FederacionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_federacion;
	
	private String cif;
	
	private String Direccion;
	
	private Integer telefono;
	
	@OneToMany(mappedBy = "federacion")
	@JsonIgnoreProperties("federacion")
	private List<DepartamentoModel> departamentos;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_torneo")
	@JsonIgnoreProperties("torneos")
	private TorneoModel torneo;
	
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
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public List<DepartamentoModel> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<DepartamentoModel> departamentos) {
		this.departamentos = departamentos;
	}

	public TorneoModel getTorneo() {
		return torneo;
	}

	public void setTorneo(TorneoModel torneo) {
		this.torneo = torneo;
	}
	
	
}
