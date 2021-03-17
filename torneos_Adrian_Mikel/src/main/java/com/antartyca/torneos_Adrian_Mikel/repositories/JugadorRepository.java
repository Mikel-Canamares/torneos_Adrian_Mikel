package com.antartyca.torneos_Adrian_Mikel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antartyca.torneos_Adrian_Mikel.models.JugadorModel;

@Repository
public interface JugadorRepository extends JpaRepository<JugadorModel, Integer>{

}
