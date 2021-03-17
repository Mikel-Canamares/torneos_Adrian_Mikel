package com.antartyca.torneos_Adrian_Mikel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.antartyca.torneos_Adrian_Mikel.models.TorneoModel;

@Repository
public interface TorneoRepository extends JpaRepository<TorneoModel, Integer>{

}
