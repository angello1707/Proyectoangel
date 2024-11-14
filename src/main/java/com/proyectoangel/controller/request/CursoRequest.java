package com.proyectoangel.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CursoRequest {

    private int id;
    private String titulo;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_fin;
    private String estado;

}
