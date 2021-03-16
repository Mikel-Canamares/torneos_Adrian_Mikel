package com.antartyca.torneos_Adrian_Mikel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.antartyca.torneos_Adrian_Mikel.models.JugadorModel;

@Repository
public interface JugadorRepository extends CrudRepository<JugadorModel, Integer>{

}
