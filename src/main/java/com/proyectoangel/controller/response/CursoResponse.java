package com.proyectoangel.controller.response;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CursoResponse {
    private int curso_id;
    private String titulo;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_fin;
    private String estado;
}
