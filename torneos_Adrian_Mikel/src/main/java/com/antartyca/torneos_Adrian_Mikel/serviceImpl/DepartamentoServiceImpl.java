package com.antartyca.torneos_Adrian_Mikel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antartyca.torneos_Adrian_Mikel.models.DepartamentoModel;
import com.antartyca.torneos_Adrian_Mikel.repositories.DepartamentoRepository;
import com.antartyca.torneos_Adrian_Mikel.services.IDepartamentoService;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService{
	
	@Autowired
	private DepartamentoRepository departamentoRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<DepartamentoModel> findAll() {
		return (List<DepartamentoModel>) departamentoRepo.findAll();
	}

	@Override
	public void save(DepartamentoModel departamento) {
		departamentoRepo.save(departamento);
		
	}

	@Override
	@Transactional(readOnly = true)
	public DepartamentoModel findOne(Integer id) {
		return departamentoRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		departamentoRepo.deleteById(id);
		
	}
}
