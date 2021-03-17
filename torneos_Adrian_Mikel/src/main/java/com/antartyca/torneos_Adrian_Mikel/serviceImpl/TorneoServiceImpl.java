package com.antartyca.torneos_Adrian_Mikel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.antartyca.torneos_Adrian_Mikel.models.TorneoModel;

import com.antartyca.torneos_Adrian_Mikel.repositories.TorneoRepository;
import com.antartyca.torneos_Adrian_Mikel.services.ITorneoService;

@Service
public class TorneoServiceImpl implements ITorneoService{

	@Autowired
	private TorneoRepository torneoRepo;
	
	@Override
	public List<TorneoModel> findAll() {
		return (List<TorneoModel>) torneoRepo.findAll();
	}
	

	@Override
	public void save(TorneoModel torneo) {
		torneoRepo.save(torneo);
		
	}

	@Override
	@Transactional(readOnly = true)
	public TorneoModel findOne(Integer id) {
		return torneoRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		torneoRepo.deleteById(id);
		
	}




}
