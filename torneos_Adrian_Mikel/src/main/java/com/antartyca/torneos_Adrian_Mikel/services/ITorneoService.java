package com.antartyca.torneos_Adrian_Mikel.services;

import java.util.List;

import com.antartyca.torneos_Adrian_Mikel.models.EquipoModel;
import com.antartyca.torneos_Adrian_Mikel.models.TorneoModel;

public interface ITorneoService {

	public List<TorneoModel> findAll();

	public void save(TorneoModel torneo);
	
	//public void saveAllEquipos(List<EquipoModel> equipos);
	
	public TorneoModel findOne(Integer id);
	
	public void delete(Integer id);
	
	
}
