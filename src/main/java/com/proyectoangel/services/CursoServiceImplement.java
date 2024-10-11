package com.proyectoangel.services;


import com.proyectoangel.entitys.Curso;
import com.proyectoangel.entitys.repository.CursoRepository;
import com.proyectoangel.services.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImplement implements CursoService {

    private final CursoRepository cursoRepository;

    @Override
    public List<Curso> getListCurso() {

        return cursoRepository.listCursos();
    }

}
