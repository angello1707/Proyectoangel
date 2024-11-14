package com.proyectoangel.services.service;

import com.proyectoangel.controller.request.UsuarioRequest;
import com.proyectoangel.controller.response.UsuarioResponse;
import com.proyectoangel.entitys.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getListUsuarios();
    void deleteUser(int id);
    UsuarioResponse searchUser(int id);
    void saveUser(UsuarioRequest usuarioRequest);
    void updateUser(UsuarioRequest usuarioRequest);
}
