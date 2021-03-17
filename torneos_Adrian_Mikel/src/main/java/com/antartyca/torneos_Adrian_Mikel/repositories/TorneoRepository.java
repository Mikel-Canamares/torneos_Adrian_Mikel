package com.antartyca.torneos_Adrian_Mikel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antartyca.torneos_Adrian_Mikel.models.EquipoModel;
import com.antartyca.torneos_Adrian_Mikel.models.TorneoModel;

@Repository
public interface TorneoRepository extends JpaRepository<TorneoModel, Integer>{

	//List<TorneoModel> findByNombre(String nombre);

	
}
