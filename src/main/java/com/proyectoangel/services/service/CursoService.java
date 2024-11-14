package com.proyectoangel.services.service;

import com.proyectoangel.controller.request.CursoRequest;
import com.proyectoangel.controller.response.CursoResponse;
import com.proyectoangel.entitys.Curso;

import java.util.List;

public interface CursoService {

    List<Curso> getListCurso();
    void deleteCurso(int id);
    CursoResponse searchCurso(int id);
    void saveCurso(CursoRequest usuarioRequest);
    void updateCurso(CursoRequest cursoRequest);

}
