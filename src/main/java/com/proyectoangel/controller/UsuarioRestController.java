package com.proyectoangel.controller;

import com.proyectoangel.controller.request.UsuarioRequest;
import com.proyectoangel.controller.response.UsuarioResponse;
import com.proyectoangel.entitys.Usuario;
import com.proyectoangel.services.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/v1")
@RequiredArgsConstructor
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> listUsuariosApi() {
        List<Usuario> usuarioList = usuarioService.getListUsuarios();
        return new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUsuarioApi(@RequestParam(name = "id") int id) {
        usuarioService.deleteUser(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<UsuarioResponse> searchUsuarioApi(@PathVariable int id) {
        UsuarioResponse usuarioResponse = usuarioService.searchUser(id);
        return ResponseEntity.ok(usuarioResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUsuarioApi(@RequestBody UsuarioRequest usuarioRequest) {
        try {
            usuarioService.saveUser(usuarioRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario guardado exitosamente.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateUsuarioApi(@RequestBody UsuarioRequest usuarioRequest) {
        usuarioService.updateUser(usuarioRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }


}
