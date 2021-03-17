package com.antartyca.torneos_Adrian_Mikel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antartyca.torneos_Adrian_Mikel.models.FederacionModel;

@Repository
public interface FederacionRepository extends JpaRepository<FederacionModel,Integer>{

}
