package com.antartyca.torneos_Adrian_Mikel.services;

import java.util.List;

import com.antartyca.torneos_Adrian_Mikel.models.DepartamentoModel;



public interface IDepartamentoService {
	public List<DepartamentoModel> findAll();

	public void save(DepartamentoModel equipo);
	
	public DepartamentoModel findOne(Integer id);
	
	public void delete(Integer id);
}
