package com.antartyca.torneos_Adrian_Mikel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antartyca.torneos_Adrian_Mikel.models.EquipoModel;
import com.antartyca.torneos_Adrian_Mikel.repositories.EquipoRepository;
import com.antartyca.torneos_Adrian_Mikel.services.IEquipoService;

@Service
public class EquipoServiceImpl implements IEquipoService{

	@Autowired
	private EquipoRepository equipoRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<EquipoModel> findAll() {
		return (List<EquipoModel>) equipoRepo.findAll();
	}

	@Override
	public void save(EquipoModel equipo) {
		equipoRepo.save(equipo);
		
	}

	@Override
	@Transactional(readOnly = true)
	public EquipoModel findOne(Integer id) {
		return equipoRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		equipoRepo.deleteById(id);
		
	}

}
