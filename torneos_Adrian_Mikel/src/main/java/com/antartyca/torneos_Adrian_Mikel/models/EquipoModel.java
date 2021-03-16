package com.antartyca.torneos_Adrian_Mikel.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "EQUIPOS")
public class EquipoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_equipo;
	
	private String nombre;
	private String direccion;
	private Date  fecha_fundacion;
	
	@OneToMany(mappedBy = "equipo")
	@JsonIgnoreProperties("equipo")
	private List<JugadorModel> jugadores;
	
	@ManyToMany
	@JoinTable(name = "participa",
	joinColumns = @JoinColumn(name = "id_equipo"),
	inverseJoinColumns = @JoinColumn(name= "id_torneo"))
	private List<TorneoModel> torneos;
	
	
	@ManyToOne
	@JoinColumn(name = "cod_ciudad")
	@JsonIgnoreProperties("torneos")
	private CiudadModel ciudad;
	
	@ManyToOne
	@JoinColumn(name = "id_federacion")
	@JsonIgnoreProperties("torneos")
	private FederacionModel federacion;
	
	
	public Integer getId_equipo() {
		return id_equipo;
	}
	public void setId_equipo(Integer id_equipo) {
		this.id_equipo = id_equipo;
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
	public Date getFecha_fundacion() {
		return fecha_fundacion;
	}
	public void setFecha_fundacion(Date fecha_fundacion) {
		this.fecha_fundacion = fecha_fundacion;
	}
	public List<JugadorModel> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<JugadorModel> jugadores) {
		this.jugadores = jugadores;
	}
	public List<TorneoModel> getTorneos() {
		return torneos;
	}
	public void setTorneos(List<TorneoModel> torneos) {
		this.torneos = torneos;
	}
	public CiudadModel getCiudad() {
		return ciudad;
	}
	public void setCiudad(CiudadModel ciudad) {
		this.ciudad = ciudad;
	}
	public FederacionModel getFederacion() {
		return federacion;
	}
	public void setFederacion(FederacionModel federacion) {
		this.federacion = federacion;
	}
	
	
	
	
}
