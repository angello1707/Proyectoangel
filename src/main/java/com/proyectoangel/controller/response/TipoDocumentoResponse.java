package com.proyectoangel.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TipoDocumentoResponse {

    private int tipo_documento_id;

    private String sigla;

    private String descripcion;
}
