package com.antartyca.torneos_Adrian_Mikel.services;

import java.util.List;


import com.antartyca.torneos_Adrian_Mikel.models.JugadorModel;

public interface IJugadorService {

	public List<JugadorModel> findAll();

	public void save(JugadorModel jugador);
	
	public JugadorModel findOne(Integer id);
	
	public void delete(Integer id);
}
