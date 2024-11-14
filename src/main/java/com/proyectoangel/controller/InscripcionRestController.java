package com.proyectoangel.controller;

import com.proyectoangel.controller.request.InscripcionRequest;
import com.proyectoangel.controller.response.InscripcionResponse;
import com.proyectoangel.entitys.Inscripcion;
import com.proyectoangel.services.service.InscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    // Buscar una inscripción por su ID
    @GetMapping("/search/{id}")
    public ResponseEntity<InscripcionResponse> searchInscripcion(@PathVariable int id) {
        InscripcionResponse inscripcionresponse = inscripcionService.searchInscripcion(id);
        return ResponseEntity.ok(inscripcionresponse);
    }

    // Guardar una nueva inscripción
    @PostMapping("/save")
    public ResponseEntity<String> saveInscripcion(@RequestBody InscripcionRequest inscripcionRequest) {
        inscripcionService.saveInscripcion(inscripcionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Inscripción creada exitosamente");
    }

    // Actualizar una inscripción existente
    @PutMapping("/update")
    public ResponseEntity<String> updateInscripcion(@RequestBody InscripcionRequest inscripcionRequest) {
        inscripcionService.updateInscripcion(inscripcionRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Inscripción actualizada exitosamente");
    }

    // Eliminar una inscripción por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInscripcion(@PathVariable int id) {
        inscripcionService.deleteInscripcion(id);
        return ResponseEntity.status(HttpStatus.OK).body("Inscripción eliminada exitosamente");
    }
}
