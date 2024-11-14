package com.proyectoangel.entitys.repository;


import com.proyectoangel.entitys.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {

    @Query(value="SELECT * FROM Inscripciones",nativeQuery= true)
    List<Inscripcion> listInscripciones();

    @Query(value = "SELECT * FROM Inscripciones WHERE CASE inscripcion_id =:id", nativeQuery = true)//lo hace de forma nativa lo hace mas rapido
    Inscripcion searchInscripcion(@Param(value = "id") int id);
}
