package com.antartyca.torneos_Adrian_Mikel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.antartyca.torneos_Adrian_Mikel.models.EquipoModel;


public interface EquipoRepository extends JpaRepository<EquipoModel, Integer> {

	
}
