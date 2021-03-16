package com.antartyca.torneos_Adrian_Mikel.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPOS")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_equipo;
	
	private String nombre;
	private String direccion;
	private Date  fecha_fundacion;
	
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
	
	
}
