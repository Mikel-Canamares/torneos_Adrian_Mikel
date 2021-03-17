package com.antartyca.torneos_Adrian_Mikel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antartyca.torneos_Adrian_Mikel.models.DepartamentoModel;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoModel,Integer>{

}
