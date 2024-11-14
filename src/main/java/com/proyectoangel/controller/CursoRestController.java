package com.proyectoangel.controller;

import com.proyectoangel.controller.request.CursoRequest;
import com.proyectoangel.controller.response.CursoResponse;
import com.proyectoangel.entitys.Curso;
import com.proyectoangel.services.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCursoApi(@RequestParam(name = "id") int id) {
        cursoService.deleteCurso(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<CursoResponse> searchCursoApi(@PathVariable int id) {
        CursoResponse cursoResponse = cursoService.searchCurso(id);
        return ResponseEntity.ok(cursoResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCursoApi(@RequestBody CursoRequest cursoRequest) {
        cursoService.saveCurso(cursoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCursoApi(@RequestBody CursoRequest cursoRequest) {
        cursoService.updateCurso(cursoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
}
