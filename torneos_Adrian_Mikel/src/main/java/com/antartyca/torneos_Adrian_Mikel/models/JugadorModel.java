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
@Table(name = "JUGADORES")
public class JugadorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_jugador;
	private String dni;
	private String nombre;
	private String telefono;
	private String puesto;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_equipo")
	@JsonIgnoreProperties("jugadores")
	private EquipoModel equipo;
	
	
	public Integer getId_jugador() {
		return id_jugador;
	}
	public void setId_jugador(Integer id_jugador) {
		this.id_jugador = id_jugador;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public EquipoModel getEquipo() {
		return equipo;
	}
	public void setEquipo(EquipoModel equipo) {
		this.equipo = equipo;
	}
	
	
	
}
