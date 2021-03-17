package com.antartyca.torneos_Adrian_Mikel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.repository.CrudRepository;
=======
>>>>>>> 594de72 (errores de repositorios corregidos)
import org.springframework.stereotype.Repository;

import com.antartyca.torneos_Adrian_Mikel.models.TorneoModel;

@Repository
public interface TorneoRepository extends JpaRepository<TorneoModel, Integer>{

}
