package com.antartyca.torneos_Adrian_Mikel.services;

import java.util.List;

import com.antartyca.torneos_Adrian_Mikel.models.FederacionModel;

public interface IFederacionService {
	public List<FederacionModel> findAll();

	public void save(FederacionModel equipo);
	
	public FederacionModel findOne(Integer id);
	
	public void delete(Integer id);
}
