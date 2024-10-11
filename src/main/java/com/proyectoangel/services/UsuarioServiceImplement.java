package com.proyectoangel.services;

import com.proyectoangel.entitys.Usuario;
import com.proyectoangel.entitys.repository.UsuarioRepository;
import com.proyectoangel.services.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImplement implements UsuarioService {


    private final UsuarioRepository usuarioRepository;



    @Override
    public List<Usuario> getListUsuarios(){
        return usuarioRepository.listUsuarios();

    }


}
