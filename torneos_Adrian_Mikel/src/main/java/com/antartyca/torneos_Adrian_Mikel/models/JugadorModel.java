package com.antartyca.torneos_Adrian_Mikel.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "jugador")
public class JugadorModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_jugador;
	
	private String dni;
	
	private String nombre;
	
	private String telefono;
	
	private String puesto;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_equipo", foreignKey =  @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
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
