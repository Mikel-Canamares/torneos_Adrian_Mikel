package com.antartyca.torneos_Adrian_Mikel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antartyca.torneos_Adrian_Mikel.models.FederacionModel;
import com.antartyca.torneos_Adrian_Mikel.repositories.FederacionRepository;
import com.antartyca.torneos_Adrian_Mikel.services.IFederacionService;

@Service
public class FederacionServiceImpl implements IFederacionService{
	
	@Autowired
	private FederacionRepository federacionRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<FederacionModel> findAll() {
		return (List<FederacionModel>) federacionRepo.findAll();
	}

	@Override
	public void save(FederacionModel federacion) {
		federacionRepo.save(federacion);
		
	}

	@Override
	@Transactional(readOnly = true)
	public FederacionModel findOne(Integer id) {
		return federacionRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		federacionRepo.deleteById(id);
		
	}
}
