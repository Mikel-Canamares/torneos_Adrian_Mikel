package com.antartyca.torneos_Adrian_Mikel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antartyca.torneos_Adrian_Mikel.models.EmpleadoModel;
import com.antartyca.torneos_Adrian_Mikel.repositories.EmpleadoRepository;
import com.antartyca.torneos_Adrian_Mikel.services.IEmpleadoService;


@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<EmpleadoModel> findAll() {
		return (List<EmpleadoModel>) empleadoRepo.findAll();
	}

	@Override
	public void save(EmpleadoModel empleado) {
		empleadoRepo.save(empleado);
		
	}

	@Override
	@Transactional(readOnly = true)
	public EmpleadoModel findOne(Integer id) {
		return empleadoRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		empleadoRepo.deleteById(id);
		
	}
}
