package com.proyectoangel.entitys.repository;


import com.proyectoangel.entitys.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {

    @Query(value="SELECT * FROM Inscripciones",nativeQuery= true)
    List<Inscripcion> listInscripciones();
}
