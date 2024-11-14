package com.proyectoangel.controller.response;

import com.proyectoangel.entitys.TipoDocumento;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioResponse {

    private int usuario_id;

    private String nombre_usuario;

    private String apellido_usuario;

    private TipoDocumentoResponse tipoDocumentoResponse;

    private String documento;

    private String email;

    private String password;

    private String empresa;

    private String telefono;

}
