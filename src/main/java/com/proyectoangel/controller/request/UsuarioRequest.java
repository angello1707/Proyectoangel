package com.proyectoangel.controller.request;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    private int id;

    private String nombre_usuario;

    private String apellido_usuario;

    private int tipo_documento;

    private String documento;

    private String email;

    private String password;

    private String empresa;

    private String telefono;

}
