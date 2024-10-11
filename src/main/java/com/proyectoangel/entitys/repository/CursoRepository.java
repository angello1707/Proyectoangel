package com.proyectoangel.entitys.repository;

import com.proyectoangel.entitys.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

    @Query(value="SELECT * FROM Cursos",nativeQuery= true)
    List<Curso> listCursos();

}
