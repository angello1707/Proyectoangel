package com.proyectoangel.controller.request;

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
public class InscripcionRequest {

    private int inscripcion_id; // Campo para identificar la inscripción en caso de actualización
    private int usuario_id;     // ID del usuario asociado
    private int curso_id;       // ID del curso asociado
    private LocalDateTime fecha_inscripcion; // Fecha en que se realiza la inscripción
    private String contenido_formulario;     // Información adicional del formulario de inscripción

}