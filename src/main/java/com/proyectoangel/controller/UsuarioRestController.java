package com.proyectoangel.controller;


import com.proyectoangel.entitys.Usuario;
import com.proyectoangel.services.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/usuarios")
@RequiredArgsConstructor

public class UsuarioRestController {

    private final UsuarioService usuarioService;

    @GetMapping("/list")
    public ResponseEntity <List<Usuario>> listUsuariosApi(){
        List<Usuario> usuarioList=usuarioService.getListUsuarios();
        return new ResponseEntity<>(usuarioList, HttpStatus.ACCEPTED);
    }

}
