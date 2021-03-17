package com.antartyca.torneos_Adrian_Mikel.services;

import java.util.List;

import com.antartyca.torneos_Adrian_Mikel.models.CiudadModel;

public interface ICiudadService {
	public List<CiudadModel> findAll();

	public void save(CiudadModel equipo);
	
	public CiudadModel findOne(Integer id);
	
	public void delete(Integer id);
}
