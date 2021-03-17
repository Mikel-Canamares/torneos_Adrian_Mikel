package com.antartyca.torneos_Adrian_Mikel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antartyca.torneos_Adrian_Mikel.models.JugadorModel;
import com.antartyca.torneos_Adrian_Mikel.repositories.JugadorRepository;
import com.antartyca.torneos_Adrian_Mikel.services.IJugadorService;

@Service
public class JugadorServiceImpl  implements IJugadorService{

	@Autowired
	private JugadorRepository jugadorRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<JugadorModel> findAll() {
		return (List<JugadorModel>) jugadorRepo.findAll();
	}

	@Override
	public void save(JugadorModel jugador) {
		jugadorRepo.save(jugador);
		
	}

	@Override
	public JugadorModel findOne(Integer id) {
		return jugadorRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		jugadorRepo.deleteById(id);
		
	}

}
