package com.antartyca.torneos_Adrian_Mikel.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "equipo")
public class EquipoModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_equipo;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String direccion;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date  fecha_fundacion;
	
	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("equipo")
	private List<JugadorModel> jugadores;
	
//	@ManyToMany
//	@JoinTable(name = "participa",
//	joinColumns = @JoinColumn(name = "id_equipo"),
//	inverseJoinColumns = @JoinColumn(name= "id_torneo"))
//	private List<TorneoModel> torneos;
	
	@ManyToMany(mappedBy = "equipos")
	private List<TorneoModel> torneos;
	
	
	
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	
}
