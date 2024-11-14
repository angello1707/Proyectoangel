package com.proyectoangel.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscripcionResponse {

    private int inscripcion_id; // ID de la inscripción
    private int usuario_id;     // ID del usuario inscrito
    private int curso_id;       // ID del curso en el que se inscribe
    private LocalDateTime fecha_inscripcion; // Fecha de inscripción
    private String contenido_formulario;     // Contenido del formulario asociado

}