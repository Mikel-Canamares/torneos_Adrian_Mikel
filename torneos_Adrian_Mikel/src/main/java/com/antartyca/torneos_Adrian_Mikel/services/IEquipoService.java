package com.antartyca.torneos_Adrian_Mikel.services;

import java.util.List;

import com.antartyca.torneos_Adrian_Mikel.models.EquipoModel;

public interface IEquipoService {

	public List<EquipoModel> findAll();

	public void save(EquipoModel equipo);
	
	public EquipoModel findOne(Integer id);
	
	public void delete(Integer id);
}
