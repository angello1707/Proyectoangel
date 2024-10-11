package com.proyectoangel.controller;

import com.proyectoangel.entitys.Inscripcion;
import com.proyectoangel.services.service.InscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/inscripciones")
@RequiredArgsConstructor

public class InscripcionRestController {
    private final InscripcionService inscripcionService;

    @GetMapping("/list")
    public ResponseEntity<List<Inscripcion>> listIncripcionApi(){
            List<Inscripcion> InscripcionList=inscripcionService.getListInscripcion();
        return new ResponseEntity<>(InscripcionList, HttpStatus.ACCEPTED);
    }
}
