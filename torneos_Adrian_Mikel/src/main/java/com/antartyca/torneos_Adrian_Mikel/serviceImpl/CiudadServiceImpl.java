package com.antartyca.torneos_Adrian_Mikel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antartyca.torneos_Adrian_Mikel.models.CiudadModel;
import com.antartyca.torneos_Adrian_Mikel.repositories.CiudadRepository;
import com.antartyca.torneos_Adrian_Mikel.services.ICiudadService;

@Service
public class CiudadServiceImpl implements ICiudadService{
	@Autowired
	private CiudadRepository ciudadRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<CiudadModel> findAll() {
		return (List<CiudadModel>) ciudadRepo.findAll();
	}

	@Override
	public void save(CiudadModel ciudad) {
		ciudadRepo.save(ciudad);
		
	}

	@Override
	@Transactional(readOnly = true)
	public CiudadModel findOne(Integer id) {
		return ciudadRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		ciudadRepo.deleteById(id);
		
	}
}
