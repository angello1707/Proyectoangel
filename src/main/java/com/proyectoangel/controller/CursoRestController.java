package com.proyectoangel.controller;


import com.proyectoangel.entitys.Curso;
import com.proyectoangel.services.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/cursos")
@RequiredArgsConstructor

public class CursoRestController {
    private final CursoService cursoService;

    @GetMapping("/list")
    public ResponseEntity<List<Curso>> listCursoApi(){
        List<Curso> CursoList=cursoService.getListCurso();
        return new ResponseEntity<>(CursoList, HttpStatus.ACCEPTED);
    }

}
