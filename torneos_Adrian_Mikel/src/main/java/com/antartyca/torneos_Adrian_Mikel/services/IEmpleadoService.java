package com.antartyca.torneos_Adrian_Mikel.services;

import java.util.List;

import com.antartyca.torneos_Adrian_Mikel.models.EmpleadoModel;

public interface IEmpleadoService {
	public List<EmpleadoModel> findAll();

	public void save(EmpleadoModel equipo);
	
	public EmpleadoModel findOne(Integer id);
	
	public void delete(Integer id);
}
